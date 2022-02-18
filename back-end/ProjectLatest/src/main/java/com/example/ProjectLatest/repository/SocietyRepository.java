package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.Society;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SocietyRepository extends JpaRepository<Society, Long>{
    @Query(value = "Select * from society s where s.isDeleted=0",nativeQuery = true)
    List<Society> findAll();
}
