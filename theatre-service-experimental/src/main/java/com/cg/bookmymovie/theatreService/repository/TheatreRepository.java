package com.cg.bookmymovie.theatreService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookmymovie.theatreService.entity.Theatre;

@Repository
public interface TheatreRepository extends MongoRepository<Theatre, Integer>{

	
}
