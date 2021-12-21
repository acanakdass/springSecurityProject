package com.springapps.springSecurityProject.api;

import com.springapps.springSecurityProject.entities.Dtos.RoleToUserDto;
import com.springapps.springSecurityProject.entities.Role;
import com.springapps.springSecurityProject.entities.User;
import com.springapps.springSecurityProject.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri = URI.create((ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString()));
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create((ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString()));
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addToUser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserDto roleToUserDto){
        userService.addRoleToUser(roleToUserDto.username,roleToUserDto.roleName);
        return ResponseEntity.ok().build();
    }
}

