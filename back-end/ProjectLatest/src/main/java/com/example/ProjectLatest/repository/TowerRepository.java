package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.Tower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TowerRepository extends JpaRepository<Tower,Long> {
}
