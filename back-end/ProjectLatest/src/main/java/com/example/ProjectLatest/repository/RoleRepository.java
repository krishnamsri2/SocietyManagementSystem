package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long>
{

    Role findRoleByUserDetailsId(Long userId);
}