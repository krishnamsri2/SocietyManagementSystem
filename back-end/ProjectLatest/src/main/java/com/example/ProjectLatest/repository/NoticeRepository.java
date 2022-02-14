package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    Notice findByUserId(long userId);
}
