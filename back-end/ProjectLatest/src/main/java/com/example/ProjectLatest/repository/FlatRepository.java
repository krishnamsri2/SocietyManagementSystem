package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.Flat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FlatRepository extends JpaRepository<Flat,Long> {

    @Query(value = "SELECT * FROM flat f where f.flat_no = ?1 AND f.tower_id = ?2",nativeQuery = true)
    public Flat getByFlatNo(String flatNo,long towerId);

}
