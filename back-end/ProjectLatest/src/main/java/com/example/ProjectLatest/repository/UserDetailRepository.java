package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDetailRepository extends JpaRepository<UserDetails,Long > {
    @Query(value = "SELECT * FROM user_details u WHERE u.userid = ?1",nativeQuery = true)
    UserDetails getByUserId(long id);
}
