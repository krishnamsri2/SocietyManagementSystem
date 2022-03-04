package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.Notice;
import com.example.ProjectLatest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    @Query(value = "SELECT * FROM notice n WHERE n.is_deleted = 0",nativeQuery = true)
    List<Notice> findAllActive();
}
