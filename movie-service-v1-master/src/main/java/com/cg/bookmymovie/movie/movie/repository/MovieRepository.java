package com.cg.bookmymovie.movie.movie.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookmymovie.movie.movie.entity.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String>{

	Optional<Movie> findMovieByMovieName(String movieName);

}
