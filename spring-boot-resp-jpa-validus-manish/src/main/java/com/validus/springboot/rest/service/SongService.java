package com.validus.springboot.rest.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.validus.springboot.rest.exception.ResourceNotFoundException;
import com.validus.springboot.rest.model.Song;
import com.validus.springboot.rest.repository.SongRepository;

@Component
public class SongService {

	@Autowired
	private SongRepository songRepository;

	public List<Song> retrieveAllSongs() {
		return songRepository.findAll();
	}

	public Song retrieveSong(long id) throws ResourceNotFoundException {

		Song song  = songRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Song not found for this id :: " + id));				

		return song;
	}

	public ResponseEntity<Object> deleteSong(long id) {

		songRepository.deleteById(id);
		
		return ResponseEntity.ok("Success");
	}

	public ResponseEntity<Object> createSong(Song song) {
		Song savedSong = songRepository.save(song);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedSong.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	public ResponseEntity<Object> updateSong(Song song, long id) throws ResourceNotFoundException {
	    
		songRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Song not found for this id :: " + id));				
		
		song.setId(id);

		songRepository.save(song);

		return ResponseEntity.ok("Success");
	
	}

	public ResponseEntity<Object> partialUpdateSong(Song song, long id) throws ResourceNotFoundException {

		Song fetchedSong = songRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Song not found for this id :: " + id));				
			song.setId(id);
		
		fetchedSong.setName(song.getName());
		fetchedSong.setTrack(song.getTrack());
		fetchedSong.setAlbum(song.getAlbum());
		
		songRepository.save(fetchedSong);
		
		return ResponseEntity.ok("Success");
	}

}