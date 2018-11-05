package com.validus.springboot.rest.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "ALBUM")
public class Album {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer yearReleased;
	
	@Column(name = "CREATED", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public Timestamp created;	

	@Column(name = "LAST_MODIFIED", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp lastModified;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, 
            fetch = FetchType.LAZY,
            mappedBy = "album")
    private Set<Song> songs = new HashSet<>();	
	
	
	public Album() {
		super();
	}

	public Album(Long id, String name, Integer yearReleased, Timestamp created, Timestamp lastModified) {
		super();
		this.id = id;
		this.name = name;
		this.yearReleased = yearReleased;
		this.created = created;
		this.lastModified = lastModified;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getYearReleased() {
		return yearReleased;
	}

	public void setYearReleased(Integer yearReleased) {
		this.yearReleased = yearReleased;
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

	public Set<Song> getSongs() {
		return songs;
	}

	public void setSongs(Set<Song> songs) {
		this.songs = songs;
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