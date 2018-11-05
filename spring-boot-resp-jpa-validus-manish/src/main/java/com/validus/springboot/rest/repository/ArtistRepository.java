package com.validus.springboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.validus.springboot.rest.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long>{

}