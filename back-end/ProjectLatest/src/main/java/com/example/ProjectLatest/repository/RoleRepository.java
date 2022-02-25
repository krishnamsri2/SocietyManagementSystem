package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.Role;
import com.example.ProjectLatest.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long>
{
   /* @Query(value = "SELECT * FROM role r WHERE r.role_type = ?1 ", nativeQuery = true)
    List<Role> findAllByRoleType(String roleType);

    @Query(value = "SELECT * FROM role r WHERE r.role_type = ?1 AND r.is_menu_assigned", nativeQuery = true)
    List<Role> findAllByIsAssigned(String roleType);*/
}