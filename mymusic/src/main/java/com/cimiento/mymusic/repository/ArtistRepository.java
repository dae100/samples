package com.cimiento.mymusic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cimiento.mymusic.entity.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
	
    @Query(value = "SELECT a FROM Artist a LEFT JOIN FETCH a.products where a.id = :id")
    Artist findArtistWithProductsById(@Param("id") int id);

    @Query(value = "SELECT a FROM Artist a LEFT JOIN FETCH a.products")
    List<Artist> findAllWithProducts();
    
}
