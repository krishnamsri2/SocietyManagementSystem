package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.Role;

import com.example.ProjectLatest.entity.UserDetails;
import com.example.ProjectLatest.repository.RoleRepository;
import com.example.ProjectLatest.repository.UserDetailRepository;
import com.example.ProjectLatest.response.RoleResponse;

import com.example.ProjectLatest.to.RoleTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleService
{
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserDetailRepository userDetailsRepository;

    //POST request
    public void addRole(RoleTO role,Long userID)
    {
        try {
            UserDetails usd = userDetailsRepository.getById(userID);
            Role temp = new Role(role.getRoleType(), role.getRoleDescription(), role.getRole(), userID);
            usd.getRoles().add(temp);
            temp.getUserDetails().add(usd);
            roleRepository.save(temp);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public Set<RoleResponse> findRolesByUserDetailsId(Long userId)
    {
        Set<RoleResponse> roleResponses = new HashSet<RoleResponse>();
        try{
        UserDetails usd = userDetailsRepository.getById(userId);
        Set<Role> roles = usd.getRoles();
        for(Role role:roles)
        {

            RoleResponse roleResponse = new RoleResponse(role.getRoleId(), role.getRoleType(), role.getRole(), role.getRoleDescription(),role.getIsActive(),role.getIsDeleted());
            roleResponses.add(roleResponse);
        }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return roleResponses;
    }
    public RoleResponse findRoleByRoleId(Long id)
    {
        Role currentRole = roleRepository.getById(id);
        RoleResponse response = new RoleResponse(currentRole.getRoleId(),currentRole.getRoleType(), currentRole.getRole(), currentRole.getRoleDescription(),currentRole.getIsActive(),currentRole.getIsDeleted());
        return response;
    }
    public void updateRoleByRoleId(RoleTO newRole, Long id)
    {
        try {
            Role currentRole = roleRepository.getById(id);
            currentRole.setRole(newRole.getRole());
            currentRole.setRoleType(newRole.getRoleType());
            currentRole.setRoleDescription(newRole.getRoleDescription());
            currentRole.setModifyDate();
            roleRepository.save(currentRole);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void deleteRoleByRoleId(Long id)
    {
        try {
            Role role = roleRepository.getById(id);
            role.setIsDeleted(true);
            roleRepository.save(role);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void activateRoleByRoleId(Long id)
    {
        try{
            Role role = roleRepository.getById(id);
            role.setIsActive(true);
            roleRepository.save(role);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void deactivateRoleByRoleId(Long id)
    {
        try{
            Role role = roleRepository.getById(id);
            role.setIsActive(false);
            roleRepository.save(role);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
