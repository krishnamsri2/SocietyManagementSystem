package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.Complaint;
import com.example.ProjectLatest.entity.ComplaintStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long>
{

    List<Complaint> findByComplaintStatus(ComplaintStatus complaintStatus);
    List<Complaint> findByUserId(long userId);
    @Query(value = "select * from complaint c where c.flat_id=?1",nativeQuery = true)
    List<Complaint> findByFlatId(long flatId);
}
