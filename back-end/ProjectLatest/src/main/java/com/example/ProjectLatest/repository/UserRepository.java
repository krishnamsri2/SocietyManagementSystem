package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long > {
    @Query(value = "SELECT * FROM user u WHERE u.email_id = ?1",nativeQuery = true)
    Optional<User> findByEmailId(String emailId);

    @Query(value = "SELECT * FROM user u WHERE u.reset_token = ?1",nativeQuery = true)
    Optional<User> findByResetToken(String token);
}
