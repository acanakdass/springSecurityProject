package com.springapps.springSecurityProject.repositories;

import com.springapps.springSecurityProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
