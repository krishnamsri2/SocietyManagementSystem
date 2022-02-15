package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
