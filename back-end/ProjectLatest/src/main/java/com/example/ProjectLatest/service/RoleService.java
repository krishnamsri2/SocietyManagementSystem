package com.example.ProjectLatest.service;

import com.example.ProjectLatest.entity.Notice;
import com.example.ProjectLatest.entity.Role;
import com.example.ProjectLatest.entity.User;
import com.example.ProjectLatest.entity.UserDetails;
import com.example.ProjectLatest.repository.RoleRepository;
import com.example.ProjectLatest.repository.UserDetailsRepository;
import com.example.ProjectLatest.response.RoleResponse;
import com.example.ProjectLatest.to.NoticeTO;
import com.example.ProjectLatest.to.RoleTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.theme.CookieThemeResolver;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleService
{
    //private List<Role> roles = Arrays.asList(new Role(RoleType.ADMIN,"Administrator of the society","ADMIN",112L,new UserDetails("Pushkar","Prashant",9199840155L,"pushkar.prashant@peoplestrong.com",112L,new User("mypassword",112L))),new Role(RoleType.ADMIN,"Administrator of the society","ADMIN",112L,new UserDetails("Pushkar","Prashant",9199840155L,"pushkar.prashant@peoplestrong.com",112L,new User("mypassword",112L))));
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    //POST request
    public void addRole(RoleTO role,Long userID)
    {
        UserDetails usd = userDetailsRepository.getById(userID);
        Role temp = new Role(role.getRoleType(),role.getRoleDescription(),role.getRole(),userID,usd);
        roleRepository.save(temp);
    }

    public RoleResponse findRoleByUserDetailsId(Long userId)
    {

        Role role = roleRepository.findRoleByUserDetailsId(userId);
        RoleResponse roleResponse = new RoleResponse(role.getRoleType(),role.getRole(),role.getRoleDescription());
        return roleResponse;
    }

    public void updateRole(RoleTO role, Long id)
    {
       // Role role = roleRepository.findRoleByUserId(id);
    }
}
