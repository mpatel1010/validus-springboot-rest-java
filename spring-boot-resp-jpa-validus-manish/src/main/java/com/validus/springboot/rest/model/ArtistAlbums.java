package com.validus.springboot.rest.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@IdClass(ArtistAlbumsId.class)
@Table(name = "ARTIST_ALBUMS")   
public class ArtistAlbums {
	@Id
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "artistId", insertable=true, updatable=true)	
    private Artist artist;
	
	@Id
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "albumsId", insertable=true, updatable=true)	
	private Album album;


	@Column(name = "CREATED", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public Timestamp created;	

	@Column(name = "LAST_MODIFIED", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp lastModified;
		
	public ArtistAlbums() {
		super();
	}

	public ArtistAlbums(Artist artist, Album album) {
		super();
		this.artist = artist;
		this.album = album;
	}

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

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
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



