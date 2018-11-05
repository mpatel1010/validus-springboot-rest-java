package com.validus.springboot.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.validus.springboot.rest.model.Artist;
import com.validus.springboot.rest.service.ArtistService;

@RestController
public class ArtistController {

	@Autowired
	private ArtistService artistService;
	

	@GetMapping("/artists")
	public List<Artist> retrieveAllArtists() {
		return artistService.retrieveAllArtists();
	}

	@GetMapping("/artists/{id}")
	public Artist retrieveArtist(@PathVariable long id) {
		return artistService.retrieveArtist(id);
	}

	@DeleteMapping("/artists/{id}")
	public ResponseEntity<Object> deleteArtist(@PathVariable long id) {
		 return artistService.deleteArtist(id);
	}

	@PostMapping("/artists")
	public ResponseEntity<Object> createArtist(@RequestBody Artist artist) {
		return artistService.createArtist(artist);
	}
	
	@PutMapping("/artists/{id}")
	public ResponseEntity<Object> updateArtist(@RequestBody Artist artist, @PathVariable long id) {
			return artistService.updateArtist(artist, id);
	}

	@PatchMapping("/artists/{id}")
	public ResponseEntity<Object> partialUpdateArtist(@RequestBody Artist artist, @PathVariable long id) {
			return artistService.partialUpdateArtist(artist, id);
	}

}