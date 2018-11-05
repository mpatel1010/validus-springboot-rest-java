package com.validus.springboot.rest.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.validus.springboot.rest.exception.ResourceNotFoundException;
import com.validus.springboot.rest.model.Artist;
import com.validus.springboot.rest.repository.ArtistRepository;

@Component
public class ArtistService {

	@Autowired
	private ArtistRepository artistRepository;

	public List<Artist> retrieveAllArtists() {
		return artistRepository.findAll();
	}

	public Artist retrieveArtist(long id) throws ResourceNotFoundException {

		Artist artist  = artistRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Artist not found for this id :: " + id));				

		return artist;
	}

	public ResponseEntity<Object> deleteArtist(long id) {

		artistRepository.deleteById(id);
		
		return ResponseEntity.ok("Success");
	}

	public ResponseEntity<Object> createArtist(Artist artist) {
		Artist savedArtist = artistRepository.save(artist);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedArtist.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	public ResponseEntity<Object> updateArtist(Artist artist, long id) throws ResourceNotFoundException {
	    
		artistRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Artist not found for this id :: " + id));				
		
		artist.setId(id);

		artistRepository.save(artist);

		return ResponseEntity.ok("Success");
	
	}

	public ResponseEntity<Object> partialUpdateArtist(Artist artist, long id) throws ResourceNotFoundException {

		Artist fetchedArtist = artistRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Artist not found for this id :: " + id));				
			artist.setId(id);
		
		fetchedArtist.setName(artist.getName());
		
		artistRepository.save(fetchedArtist);
		
		return ResponseEntity.ok("Success");
	}

}