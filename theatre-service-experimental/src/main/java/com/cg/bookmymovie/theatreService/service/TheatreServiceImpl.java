package com.cg.bookmymovie.theatreService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookmymovie.theatreService.entity.Theatre;
import com.cg.bookmymovie.theatreService.repository.TheatreRepository;

@Service
public class TheatreServiceImpl implements TheatreService {

	@Autowired
	private TheatreRepository theatreRepository;

	public Optional<Theatre> getTheatreById(Integer theatreId) {
		Optional<Theatre> getTheatre = theatreRepository.findById(theatreId);
		if (getTheatre.isPresent()) {
			return theatreRepository.findById(theatreId);
		}

		return null;
	}

	public void addNewTheatre(Theatre theatre) {
		theatreRepository.save(theatre);
	}

	public List<Theatre> getAllTheatres() {
		return theatreRepository.findAll();
	}

	public void updateTheatre(Theatre theatre) {
		theatreRepository.save(theatre);

	}

	public void deleteTheatre(Theatre theatre) {
		theatreRepository.delete(theatre);

	}

	@Override
	public void updateTheatre(Integer theatreId, String theatreName) {
		Theatre theatre	= theatreRepository.findById(theatreId).get();
		theatre.setTheatreName(theatreName);
		theatreRepository.save(theatre);
	}

}
