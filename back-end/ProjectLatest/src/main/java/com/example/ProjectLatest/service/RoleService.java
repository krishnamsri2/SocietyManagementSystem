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
    //private List<Role> roles = Arrays.asList(new Role(RoleType.ADMIN,"Administrator of the society","ADMIN",112L,new UserDetails("Pushkar","Prashant",9199840155L,"pushkar.prashant@peoplestrong.com",112L,new User("mypassword",112L))),new Role(RoleType.ADMIN,"Administrator of the society","ADMIN",112L,new UserDetails("Pushkar","Prashant",9199840155L,"pushkar.prashant@peoplestrong.com",112L,new User("mypassword",112L))));
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserDetailRepository userDetailsRepository;

    //POST request
    public void addRole(RoleTO role,Long userID)
    {
        UserDetails usd = userDetailsRepository.getById(userID);
        Role temp = new Role(role.getRoleType(),role.getRoleDescription(),role.getRole(),usd.getUserDetailsId());
        usd.getRoles().add(temp);
        temp.getUserDetails().add(usd);
        roleRepository.save(temp);
    }

    public Set<RoleResponse> findRolesByUserDetailsId(Long userId)
    {
        UserDetails usd = userDetailsRepository.getById(userId);
        Set<Role> roles = usd.getRoles();
        Set<RoleResponse> roleResponses = new HashSet<RoleResponse>();
        for(Role role:roles)
        {
            RoleResponse roleResponse = new RoleResponse(role.getRoleId(),role.getRoleType(),role.getRole(),role.getRoleDescription());
            roleResponses.add(roleResponse);
        }
        return roleResponses;
    }

    public void updateRoleByRoleId(RoleTO newRole, Long id)
    {
       Role currentRole = roleRepository.getById(id);
       currentRole.setRole(newRole.getRole());
       currentRole.setRoleType(newRole.getRoleType());
       currentRole.setRoleDescription(newRole.getRoleDescription());
       currentRole.setModifyDate();
       roleRepository.save(currentRole);
    }

    public void deleteRoleByRoleId(Long id)
    {
        Role role = roleRepository.getById(id);
        role.setIsDeleted(true);
        roleRepository.save(role);
    }
}
