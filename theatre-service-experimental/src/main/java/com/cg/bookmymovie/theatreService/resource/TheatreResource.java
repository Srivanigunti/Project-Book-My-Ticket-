package com.cg.bookmymovie.theatreService.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookmymovie.theatreService.entity.Theatre;
import com.cg.bookmymovie.theatreService.service.TheatreService;

@RestController // ("/u")//
@RequestMapping("/theatres")
public class TheatreResource {

	@Autowired
	private TheatreService theatreService;

	@PostMapping
	public void addMovies(@RequestBody Theatre theatre) {
		theatreService.addNewTheatre(theatre);
	}

	@GetMapping
	public ResponseEntity<List<Theatre>> getALLTheatre() {
		List<Theatre> theatres = theatreService.getAllTheatres();
		System.out.println("from theatre service "+theatres.get(0));
		return new ResponseEntity<>(theatres, HttpStatus.OK);
	}

	@GetMapping("/{theatreId}")
	public ResponseEntity<Optional<Theatre>> getTheatreById(@PathVariable Integer theatreId) {
		Optional<Theatre> theatre = theatreService.getTheatreById(theatreId);

		if (!theatre.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(theatre, HttpStatus.OK);
	}

	@PutMapping("/{theatreId}")
	public ResponseEntity<Theatre> updateTheatre(@PathVariable Integer theatreId, @RequestParam String theatreName) {

		Optional<Theatre> theatre = theatreService.getTheatreById(theatreId);
		if (!theatre.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		theatreService.updateTheatre(theatreId, theatreName);;
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{theatreId}")
	public ResponseEntity<String> deleteMovies(@PathVariable Integer theatreId) {

		Optional<Theatre> theatre = theatreService.getTheatreById(theatreId);
		if (!theatre.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		theatreService.deleteTheatre(theatre.get());
		return new ResponseEntity<>("Theatre Deleted SuccessFully", HttpStatus.OK);
	}

}