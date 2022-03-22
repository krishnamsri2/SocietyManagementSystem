package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.Complaint;
import com.example.ProjectLatest.entity.ComplaintStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long>
{

    List<Complaint> findByComplaintStatus(ComplaintStatus complaintStatus);
    List<Complaint> findByWorkerId(long workerId);
    @Query(value = "SELECT * FROM complaint c WHERE c.flat_id=?1",nativeQuery = true)
    List<Complaint> findByFlatId(long flatId);
    @Query(value = "SELECT * FROM complaint c WHERE c.worker_id=?1 AND c.complaint_status='CLOSED'",nativeQuery = true)
    List<Complaint> findByWorkerIdAndStatus(long workerId);
    @Query(value = "SELECT * FROM complaint c WHERE c.worker_id=?1 AND c.complaint_status!='CLOSED'",nativeQuery = true)
    List<Complaint> findByWorkerIdAndAssignedStatus(long workerId);
}
