package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetails,Long > {

}
