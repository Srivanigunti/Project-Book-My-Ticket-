package com.cg.bookmymovie.movie.movie.resource;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
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

import com.cg.bookmymovie.movie.movie.entity.Movie;
import com.cg.bookmymovie.movie.movie.service.MovieServiceImpl;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	@Autowired
	private MovieServiceImpl movieService;

	@PostMapping
	public ResponseEntity<String>addMovies(@RequestBody Movie movie) {
		if (LocalDate.now().compareTo(movie.getReleaseDate()) > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		movieService.addNewMovie(movie);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Movie>> getALLMovie() {
		List<Movie> movies = movieService.getAllMovie();
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}

	@GetMapping("/{movieName}")
	public ResponseEntity<Optional<Movie>> getMovieByName(@PathVariable String movieName) {
		Optional<Movie> movie = movieService.findMovieByName(movieName);

		if (!movie.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(movie, HttpStatus.OK);
	}

	@DeleteMapping("/{movieName}")
	public ResponseEntity<String> deleteMovies(@PathVariable String movieName) {

		Optional<Movie> movie = movieService.findMovieByName(movieName);
		if (!movie.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		movieService.deleteMovies(movie.get());
		return new ResponseEntity<>("Movie Deleted SuccessFully", HttpStatus.OK);
	}

	@GetMapping("/{movieName}/releaseDate")
	public ResponseEntity<String> getReleaseDate(@PathVariable String movieName) {
		Optional<Movie> movie = movieService.findMovieByName(movieName);
		return new ResponseEntity<String>(movie.get().getReleaseDate().toString(), HttpStatus.OK);
	}

	@PutMapping("/{movieName}")
	public ResponseEntity<String> updateMovieReleaseDate(@PathVariable String movieName,
			@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate releaseDate) {

		Optional<Movie> movie = movieService.findMovieByName(movieName);
		if (!movie.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else 
			if (LocalDate.now().compareTo(releaseDate) > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		movieService.updateMovieReleaseDate(movieName, releaseDate);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
