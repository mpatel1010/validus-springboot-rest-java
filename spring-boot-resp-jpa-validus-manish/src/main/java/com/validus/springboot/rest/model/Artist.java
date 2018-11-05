package com.validus.springboot.rest.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARTIST")
public class Artist {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Column(name = "CREATED", nullable = false, insertable = false, updatable = false,  columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public Timestamp created;	

	@Column(name = "LAST_MODIFIED", nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp lastModified;
	
	
	public Artist() {
		super();
	}

	public Artist(Long id, String name, Timestamp created, Timestamp lastModified) {
		super();
		this.id = id;
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