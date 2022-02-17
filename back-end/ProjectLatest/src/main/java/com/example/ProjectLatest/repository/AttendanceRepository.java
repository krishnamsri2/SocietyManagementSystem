package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
}
