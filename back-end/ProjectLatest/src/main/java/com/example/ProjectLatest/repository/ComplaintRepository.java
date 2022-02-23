package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

}
