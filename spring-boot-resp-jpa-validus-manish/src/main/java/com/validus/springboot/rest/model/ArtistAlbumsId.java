package com.validus.springboot.rest.model;

import java.io.Serializable;

public class ArtistAlbumsId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private   Artist artist;
	private   Album album;
	
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}

    @Override
    public int hashCode() {
    	// TODO - can be implemented;
    	return 1;
    }

    @Override
    public boolean equals(Object obj) {
    	// TODO - can be implemented;    	
        return true;
    }  
    
}

