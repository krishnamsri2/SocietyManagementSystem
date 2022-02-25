package com.example.ProjectLatest.repository;

import com.example.ProjectLatest.entity.MenuSecurity;
import com.example.ProjectLatest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuSecurityRepository extends JpaRepository<MenuSecurity,Long>
{
    @Query(value = "SELECT * FROM menu_security m WHERE m.menu_id = ?1 ", nativeQuery = true)
    List<MenuSecurity> findAllByMenuId(long id);

    @Query(value = "SELECT * FROM menu_security m WHERE m.menu_id = ?1 AND m.role_id = ?2", nativeQuery = true)
    MenuSecurity getByMenuIdRoleId(long menuId,long roleId);
}
