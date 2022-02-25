package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangePasswordRepository extends JpaRepository<User,Long>
{
}