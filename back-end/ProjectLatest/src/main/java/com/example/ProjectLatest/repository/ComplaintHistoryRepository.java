package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.ComplaintHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComplaintHistoryRepository extends JpaRepository<ComplaintHistory,Long>
{
    @Query(value = "SELECT * FROM complaint_history ch WHERE ch.complaint_id=?1",nativeQuery = true)
    List<ComplaintHistory> findByComplaintId(long complaintId);
}
