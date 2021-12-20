package com.springapps.springSecurityProject.service;

import com.springapps.springSecurityProject.entities.Role;
import com.springapps.springSecurityProject.entities.User;
import com.springapps.springSecurityProject.repositories.RoleRepo;
import com.springapps.springSecurityProject.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserManager implements UserService{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    /*public UserManager(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }
    ===@RequiredArgsConstructor
    */

    @Override
    public User saveUser(User user) {
        log.info("Saving new user:{} to database",user.getFirstname());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to database",role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role : {} to user: {}",roleName,username);
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Getting user : {}",username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Getting all users");
        return userRepo.findAll();
    }
}
