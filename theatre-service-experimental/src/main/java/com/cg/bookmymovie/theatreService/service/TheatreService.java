package com.cg.bookmymovie.theatreService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.bookmymovie.theatreService.entity.Theatre;

@Service
public interface TheatreService {

	void addNewTheatre(Theatre theatre);

	Optional<Theatre> getTheatreById(Integer theatreId);

	List<Theatre> getAllTheatres();

	void deleteTheatre(Theatre theatre);

	void updateTheatre(Integer theatreId, String theatreName);

	
}