package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.Society;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SocietyRepository extends JpaRepository<Society, Long>{
    @Query(value = "SELECT * FROM society s WHERE s.society_name = ?1",nativeQuery = true)
    Optional<Society> findByName(String name);
}
