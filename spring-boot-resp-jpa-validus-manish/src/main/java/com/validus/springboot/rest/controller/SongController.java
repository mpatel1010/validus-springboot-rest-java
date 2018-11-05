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

import com.validus.springboot.rest.model.Song;
import com.validus.springboot.rest.service.SongService;

@RestController
public class SongController {

	@Autowired
	private SongService songService;
	

	@GetMapping("/songs")
	public List<Song> retrieveAllSongs() {
		return songService.retrieveAllSongs();
	}

	@GetMapping("/songs/{id}")
	public Song retrieveSong(@PathVariable long id) {
		return songService.retrieveSong(id);
	}

	@DeleteMapping("/songs/{id}")
	public ResponseEntity<Object> deleteSong(@PathVariable long id) {
		 return songService.deleteSong(id);
	}

	@PostMapping("/songs")
	public ResponseEntity<Object> createSong(@RequestBody Song song) {
		return songService.createSong(song);
	}
	
	@PutMapping("/songs/{id}")
	public ResponseEntity<Object> updateSong(@RequestBody Song song, @PathVariable long id) {
			return songService.updateSong(song, id);
	}

	@PatchMapping("/songs/{id}")
	public ResponseEntity<Object> partialUpdateSong(@RequestBody Song song, @PathVariable long id) {
			return songService.partialUpdateSong(song, id);
	}

}