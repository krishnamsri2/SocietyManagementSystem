package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.Tower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TowerRepository extends JpaRepository<Tower,Long> {
    @Query(value = "SELECT * FROM tower t where t.tower_name = ?1 AND t.society_id = ?2 AND t.is_deleted = 0",nativeQuery = true)
    public Tower getByTowerName(String towerName, long societyId);
}
