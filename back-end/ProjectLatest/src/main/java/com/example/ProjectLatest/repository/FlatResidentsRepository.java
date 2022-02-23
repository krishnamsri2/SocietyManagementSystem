package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.FlatResidents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlatResidentsRepository extends JpaRepository<FlatResidents,Long> {
    @Query(value = "SELECT * FROM flat_residents f WHERE f.flat_id = ?1 ", nativeQuery = true)
    List<FlatResidents> findAllByFlatId(long id);

    @Query(value = "SELECT * FROM flat_residents f WHERE f.user_detail_id = ?1 ", nativeQuery = true)
    List<FlatResidents> findAllByUserDetailId(long userDetailId);
}
