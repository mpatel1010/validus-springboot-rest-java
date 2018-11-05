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

import com.validus.springboot.rest.model.Album;
import com.validus.springboot.rest.service.AlbumService;

@RestController
public class AlbumController {

	@Autowired
	private AlbumService albumService;
	

	@GetMapping("/albums")
	public List<Album> retrieveAllAlbums() {
		return albumService.retrieveAllAlbums();
	}

	@GetMapping("/albums/{id}")
	public Album retrieveAlbum(@PathVariable long id) {
		return albumService.retrieveAlbum(id);
	}

	@DeleteMapping("/albums/{id}")
	public ResponseEntity<Object> deleteAlbum(@PathVariable long id) {
		 return albumService.deleteAlbum(id);
	}

	@PostMapping("/albums")
	public ResponseEntity<Object> createAlbum(@RequestBody Album album) {
		return albumService.createAlbum(album);
	}
	
	@PutMapping("/albums/{id}")
	public ResponseEntity<Object> updateAlbum(@RequestBody Album album, @PathVariable long id) {
			return albumService.updateAlbum(album, id);
	}

	@PatchMapping("/albums/{id}")
	public ResponseEntity<Object> partialUpdateAlbum(@RequestBody Album album, @PathVariable long id) {
			return albumService.partialUpdateAlbum(album, id);
	}

}