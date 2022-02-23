package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AttendanceRepository extends JpaRepository<Attendance,Long> {
    @Query(value = "SELECT * FROM attendance_table WHERE created_by = ?1 AND punch_in = ?2",nativeQuery = true)
    Attendance findByUserDetailId(long id,String date);
}
