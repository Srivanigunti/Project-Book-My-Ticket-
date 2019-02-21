package com.cg.bookmymovie.websiteService.websiteController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.cg.bookmymovie.booking.entity.Address;
import com.cg.bookmymovie.booking.entity.Booking;
import com.cg.bookmymovie.movie.movie.entity.Movie;
import com.cg.bookmymovie.screeningservice.entity.Screening;
import com.cg.bookmymovie.screeningservice.entity.Seat;
import com.cg.bookmymovie.websiteService.ewallet.pojo.Ewallet;
import com.cg.bookmymovie.websiteService.profile.entity.Profile;

@RestController
//@EnableOAuth2Sso
public class WebsiteController {


	private Integer getUniqueId() {
		UUID idOne = UUID.randomUUID();
		int uid = idOne.hashCode();
		return uid;
	}

	private List<Screening> allTheatres = new ArrayList<Screening>();
	private Set<LocalDate> screeningDatesOfAMovie = new HashSet<LocalDate>();
	private String moviePoster = "";
	private Screening screen; // after selecting theatre it will be available for further processing

	@Autowired
	private RestTemplate template;

	@RequestMapping("/")
	public ModelAndView hello(Model model) {

		Set<String> cities = new HashSet<String>();

		ResponseEntity<Screening[]> screening = template.getForEntity("http://localhost:9191/screenings",
				Screening[].class);

		List<Screening> allScreenings = Arrays.asList(screening.getBody());
		Set<Screening> moviesScreening = new HashSet<Screening>();

		for (Screening screeningToValidate : allScreenings) {
			moviesScreening.add(screeningToValidate);
			String city = screeningToValidate.getTheatreAddress().getCity();
			cities.add(city);
		}
//added movies screening these days		
		model.addAttribute("screenings", moviesScreening);
		return new ModelAndView("index", "cities", cities);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/cityToSearch")
	public ModelAndView searchMovieInACity(@RequestParam String cityToSearch) {

		/*
		 * because after selecting city and getting theatres showing movieif i go back
		 * and selects some different city and then checks theatre showing movie in that
		 * city. i will get theatres of previous city also because i'm storing that data
		 * in member variable as a list.
		 */
		allTheatres.clear();
		screeningDatesOfAMovie.clear();

		Set<Screening> allMovieShowingInACity = new HashSet<Screening>();

		ResponseEntity<Screening[]> screening = template.getForEntity("http://localhost:9191/screenings",
				Screening[].class);

		List<Screening> allScreenings = Arrays.asList(screening.getBody());

		for (Screening screeningToValidate : allScreenings) {

			Address address = screeningToValidate.getTheatreAddress();

			if (address.getCity().equalsIgnoreCase(cityToSearch)) {
				allMovieShowingInACity.add(screeningToValidate);
				allTheatres.add(screeningToValidate);

				// setting all dates on which this movie will
				// be screening in this city
			}
		}
		return new ModelAndView("moviesShowing", "movies", allMovieShowingInACity);
	}

	String nameOfTheMovie = "";

	@RequestMapping("/getMovieDetails")
	public ModelAndView getMovie(@RequestParam String movieName, Model model) {
		nameOfTheMovie = "";
		screeningDatesOfAMovie.clear();
		System.out.println(movieName);
		Movie movie = template.getForObject("http://localhost:9292/movies/" + movieName, Movie.class);
		nameOfTheMovie = movie.getMovieName();
		for (Screening screening : allTheatres) {
			if (screening.getMovieName().equalsIgnoreCase(movieName)) {
				moviePoster = screening.getMoviePoster(); // it is required for subsequent request also
				model.addAttribute("moviePoster", screening.getMoviePoster());
				screeningDatesOfAMovie.add(screening.getDate());

			}
		}
		model.addAttribute("movie", movie);
		return new ModelAndView("movieDetail");
	}

	@RequestMapping("/theatreShowingMovie")
	public ModelAndView showTheatres(Model model) {
		LocalDate todaysdate = LocalDate.now();

		List<Screening> theatreShowingMovieToday = new ArrayList<Screening>();

		for (Screening screening : allTheatres) {
			if (todaysdate.equals(screening.getDate()) && screening.getMovieName().equals(nameOfTheMovie))
				theatreShowingMovieToday.add(screening);
		}

		model.addAttribute("moviePoster", moviePoster);
		model.addAttribute("theatres", theatreShowingMovieToday);
		model.addAttribute("dates", screeningDatesOfAMovie);
		return new ModelAndView("theatres");
	}

	@RequestMapping("/theatreShowingMovieByDate")
	public ModelAndView showTheatresBydate(Model model, @RequestParam String dateAsString) {
		LocalDate date = LocalDate.parse(dateAsString);
		System.out.println(dateAsString);

		List<Screening> theatreShowingMovieOnSpecificDate = new ArrayList<Screening>();
		for (Screening screening : allTheatres) {
			if (date.equals(screening.getDate()) && screening.getMovieName().equals(nameOfTheMovie))
				theatreShowingMovieOnSpecificDate.add(screening);
		}

		model.addAttribute("moviePoster", moviePoster);
		model.addAttribute("theatres", theatreShowingMovieOnSpecificDate); // here theatres is a key
		model.addAttribute("dates", screeningDatesOfAMovie);
		return new ModelAndView("theatres"); // here theatres is a jsp page
	}

	@RequestMapping("/chooseSeats")
	public ModelAndView showSeatsOfTheatre(@RequestParam String theatreName, @RequestParam String theatreState,
			@RequestParam String theatreCity, @RequestParam String theatreArea, @RequestParam String date,
			@RequestParam String startTime, Model model) {

		String[] dateArray = date.split("-");
		int year = Integer.parseInt(dateArray[0]);
		int month = Integer.parseInt(dateArray[1]);
		int day = Integer.parseInt(dateArray[2]);

		String[] timeArray = startTime.split(":");
		Integer hour = Integer.parseInt(timeArray[0]);
		Integer minute = Integer.parseInt(timeArray[1]);

		LocalDate dateIs = LocalDate.of(year, month, day);
		LocalTime timeIs = LocalTime.of(hour, minute);

		screen = new Screening();
		for (Screening screening : allTheatres) {
			if (screening.getTheatreName().equals(theatreName) && screening.getMovieName().equals(nameOfTheMovie)
					&& screening.getTheatreAddress().getState().equals(theatreState)
					&& screening.getTheatreAddress().getCity().equals(theatreCity)
					&& screening.getTheatreAddress().getArea().equals(theatreArea) && screening.getDate().equals(dateIs)
					&& screening.getStartTime().equals(timeIs)) {
				model.addAttribute("screen", screening);
				screen = screening;
				break;
			}
		}

//mapping of seatType with the numberOfSeat of that type available		
		Map<String, Integer> seatTypes = new HashMap<String, Integer>();

//to get different type of seat available		
		Set<String> typesOfSeat = new HashSet<String>();
		for (Map.Entry<Integer, Seat> entry : screen.getSeat().entrySet()) {

			typesOfSeat.add(entry.getValue().getSeatType());
		}
		Object objArray[] = typesOfSeat.toArray();

//to set number of seat available in different type of seats		

		Map<String, Double> seatsPrice = new HashMap<String, Double>();

		for (int count = 0; count < objArray.length; count++) {
			int seatsAvailable = 0;
			double price = 0.0;

			for (Map.Entry<Integer, Seat> entry : screen.getSeat().entrySet()) {
				if (entry.getValue().getSeatType().equals(objArray[count].toString())
						&& entry.getValue().isAvailable() == true)
					seatsAvailable++;
				price = entry.getValue().getPrice();
			}
			seatTypes.put(objArray[count].toString(), seatsAvailable);
			seatsPrice.put(objArray[count].toString(), price);
		}

		model.addAttribute("seatAvailable", seatTypes);
		model.addAttribute("seatprice", seatsPrice);
		return new ModelAndView("seats");
	}

	Map<String, Map<Integer, Character>> seatTypeWithDeatial = new HashMap<String, Map<Integer, Character>>();
	Map<Integer, Character> seatDetails = new HashMap<>();
	Double price = 0.0;
	Integer seats[];						//needed to update theatre later
	
	@RequestMapping("/BookSeat")
	public ModelAndView signIn(String[] seat, Model model) {
		seatTypeWithDeatial.clear();
		seatDetails.clear();
		price = 0.0;
		seats = new Integer[seat.length];
		for (int count = 0; count < seat.length; count++) {
			seats[count] = Integer.parseInt(seat[count]);
		}

		Map<Integer, Character> detailsOfSeat = new HashMap<>();
		for (int count = 0; count < seats.length; count++) {
			for (Map.Entry<Integer, Seat> entry : screen.getSeat().entrySet()) {

				if (entry.getKey() == seats[count]) {
					detailsOfSeat.clear();
					Integer seatNumber = seats[count];
					Character row = entry.getValue().getSeatRow();
					detailsOfSeat.put(seatNumber, row);
					seatDetails.putAll(detailsOfSeat);

					String seatType = entry.getValue().getSeatType();
					seatTypeWithDeatial.put(seatType, seatDetails);

					price = price + entry.getValue().getPrice();
				}
			}
		}
		return new ModelAndView("login");
	}

	@RequestMapping("/signup")
	public ModelAndView signup() {
		return new ModelAndView("Signup");
	}

	@RequestMapping("/registration")
	public ModelAndView create(@ModelAttribute Profile profile, Model model) {
		
		template.postForEntity("http://localhost:5062/profiles", profile, null);
		model.addAttribute("message", "Your profile has been successfully created....!!!!");
		return new ModelAndView("login");
	}

	Integer profileId = null;

	@RequestMapping("/validateLogin")
	public ModelAndView validateUser(@RequestParam String contactNumber, @RequestParam String password, Model model) {
		int mobileNumber = Integer.parseInt(contactNumber);
		ResponseEntity<Profile> profile = template.getForEntity("http://localhost:5062/profiles/profile?number=" + mobileNumber + "&password=" + password,
				Profile.class);
		System.out.println("hello "+profile.getStatusCodeValue()+" and "+profile.getStatusCode());
		if(profile.getBody() == null) {
			model.addAttribute("message", "Invalid credentials");
			return new ModelAndView("login");
		}
		else {
			profileId = profile.getBody().getProfileId();
			model.addAttribute("message", "Logged in successfully");
			model.addAttribute("seatSelected", seatTypeWithDeatial);
			model.addAttribute("totalPrice", price);
			return new ModelAndView("seatsSummary");
		} 
	}

	@RequestMapping(value="/BookTicket") 
	public  ModelAndView bookTicket(Model model) { 
		
		System.out.println("booking process started");
		
		
	  Booking booking = new Booking(getUniqueId(), profileId, screen.getMovieName(), screen.getTheatreName(), screen.getTheatreAddress(),
	  screen.getDate(), screen.getStartTime(), seatTypeWithDeatial, price); 
	
	  ResponseEntity<Ewallet> wallet = template.getForEntity("http://localhost:5201/wallets/"+profileId, Ewallet.class);
	  
	  if(wallet.getBody().getCurrentBalance() >= price) {
		  ResponseEntity status =  template.postForEntity("http://localhost:9393/bookings/", booking, ResponseEntity.class);
		  System.out.println("balance to deduct from wallet is:" +price);
		  template.put("http://localhost:5201/wallets/pay/"+wallet.getBody().getProfileId()+"?currentBalance="+price,null);
		  
	  //after payment if(status.getStatusCode().equals(HttpStatus.OK)) {
    
	  for (int count = 0; count < seats.length; count++) {
		  System.out.println(seats[count]);
		  screen.getSeat().get(seats[count]).setAvailable(false);
		  System.out.println( screen.getSeat().get(seats[count]).isAvailable());
	  }

	
	  template.put("http://localhost:9191/screenings/", screen);
			/*
			 * ResponseEntity<Screening> updatedScreeningEntity =
			 * template.getForEntity("http://localhost:9191/screenings/"+screen.getId(),
			 * Screening.class); screen = updatedScreeningEntity.getBody();
			 */
	  
	  model.addAttribute("message" , "booked successfully");
	  return new ModelAndView("booked");
	  }
	  else {
		  model.addAttribute("message", "you don't have enough balance in your wallet");
			return new ModelAndView("booked");
	  }
	  }

}

