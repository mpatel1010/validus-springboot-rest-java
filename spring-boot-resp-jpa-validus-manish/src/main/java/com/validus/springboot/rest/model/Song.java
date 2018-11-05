package com.validus.springboot.rest.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "SONG")
public class Song {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "albumId", insertable=true, updatable=true)
    private Album album;
	
	private Integer track;
	private String name;
	
	@Column(name = "CREATED", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public Timestamp created;	

	@Column(name = "LAST_MODIFIED", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp lastModified;	
	
	public Song() {
		super();
	}

	public Song(Long id,  String name, Integer track, Timestamp created, Timestamp lastModified) {
		super();
		this.id = id;
		this.track = track;
		this.name = name;
		this.created = created;
		this.lastModified = lastModified;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}


	public Integer getTrack() {
		return track;
	}

	public void setTrack(Integer track) {
		this.track = track;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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