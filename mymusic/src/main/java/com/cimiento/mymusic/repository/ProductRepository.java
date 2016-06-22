package com.cimiento.mymusic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cimiento.mymusic.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT p FROM Product p LEFT JOIN FETCH p.artist LEFT JOIN FETCH p.recordLabel where p.id = :id")
    Product findProductWithArtistAndRecordLabelById(@Param("id") int id);

    @Query(value = "SELECT p FROM Product p LEFT JOIN FETCH p.artist LEFT JOIN FETCH p.recordLabel")
    List<Product> findAllWithArtistAndRecordLabel();
}
