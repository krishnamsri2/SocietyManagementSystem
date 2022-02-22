package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long>
{


}
