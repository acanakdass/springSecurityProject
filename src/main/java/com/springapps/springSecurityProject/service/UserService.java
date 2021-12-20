package com.springapps.springSecurityProject.service;

import com.springapps.springSecurityProject.entities.Role;
import com.springapps.springSecurityProject.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    User getUser(String username);
    List<User> getUsers();
}
