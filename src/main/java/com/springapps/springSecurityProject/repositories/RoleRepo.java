package com.springapps.springSecurityProject.repositories;

import com.springapps.springSecurityProject.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);

}
