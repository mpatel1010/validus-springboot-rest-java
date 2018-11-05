package com.validus.springboot.rest.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.validus.springboot.rest.exception.ResourceNotFoundException;
import com.validus.springboot.rest.model.Album;
import com.validus.springboot.rest.repository.AlbumRepository;

@Component
public class AlbumService {

	@Autowired
	private AlbumRepository albumRepository;

	public List<Album> retrieveAllAlbums() {
		return albumRepository.findAll();
	}

	public Album retrieveAlbum(long id) throws ResourceNotFoundException {

		Album album  = albumRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Album not found for this id :: " + id));				

		return album;
	}

	public ResponseEntity<Object> deleteAlbum(long id) {

		albumRepository.deleteById(id);
		
		return ResponseEntity.ok("Success");
	}

	public ResponseEntity<Object> createAlbum(Album album) {
		Album savedAlbum = albumRepository.save(album);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedAlbum.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	public ResponseEntity<Object> updateAlbum(Album album, long id) throws ResourceNotFoundException {
	    
		albumRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Album not found for this id :: " + id));				
		
		album.setId(id);

		albumRepository.save(album);

		return ResponseEntity.ok("Success");
	
	}

	public ResponseEntity<Object> partialUpdateAlbum(Album album, long id) throws ResourceNotFoundException {

		Album fetchedAlbum = albumRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Album not found for this id :: " + id));				
			album.setId(id);
		
		fetchedAlbum.setName(album.getName());
		fetchedAlbum.setYearReleased(album.getYearReleased());
		
		albumRepository.save(fetchedAlbum);
		
		return ResponseEntity.ok("Success");
	}

}