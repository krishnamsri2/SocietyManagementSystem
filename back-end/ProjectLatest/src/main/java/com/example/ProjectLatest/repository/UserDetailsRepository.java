package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {

}
