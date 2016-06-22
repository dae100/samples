package com.cimiento.mymusic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cimiento.mymusic.entity.RecordLabel;

public interface RecordLabelRepository extends JpaRepository<RecordLabel, Integer> {
    @Query(value = "SELECT r FROM RecordLabel r LEFT JOIN FETCH r.products where r.id = :id")
    RecordLabel findRecordLabelWithProductsById(@Param("id") int id);

    @Query(value = "SELECT r FROM RecordLabel r LEFT JOIN FETCH r.products")
    List<RecordLabel> findAllWithProducts();
}
