package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long>
{
    @Query(value = "SELECT * FROM role r WHERE r.user_detailsid = ?1 AND r.is_deleted = 0",nativeQuery = true)
    List<Role> findAllByUSD(long userDetailsId);
}