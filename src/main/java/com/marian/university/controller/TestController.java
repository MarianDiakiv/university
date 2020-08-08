package com.marian.university.controller;

import com.marian.university.entity.ERoles;
import com.marian.university.entity.Role;
import com.marian.university.entity.User;
import com.marian.university.repository.RoleRepository;
import com.marian.university.service.RoleService;
import com.marian.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;
    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/api/open/roles")
    public List<Role> getAllRole(){
    return roleService.getAll();
}
    @GetMapping("/api/open/createroles")
    public List<Role> createRole(){
        Role role = new Role();
        role.setNameRole(ERoles.ROLE_USER);
        Role role2 = new Role();
        role2.setNameRole(ERoles.ROLE_TEACHER);
        Role role3 = new Role();
        role3.setNameRole(ERoles.ROLE_ADMIN);
        roleService.save(role);
        roleService.save(role2);
        roleService.save(role3);
        return roleService.getAll();
    }
    @GetMapping("/api/open/createuser")
    public List<User> createUsers(){
        List<Role> roles =  roleService.getAll();
        User user1 = new User();
        user1.setEmail("mariandiakiv@gmail.com");
        user1.setUserName("mariandiakiv");
        HashSet<Role>  roles1 = new HashSet<>();
        roles1.add(roles.get(2));// admin
        user1.setRole(roles1);// admin
        user1.setPassword(encoder.encode("123"));

        User user2 = new User();
        user2.setEmail("teache@gmail.com");
        user2.setUserName("mariandiakivTEACHER");
        HashSet<Role>  roles2 = new HashSet<>();
        roles2.add(roles.get(1));// teacher
        user2.setRole(roles2);//
        user2.setPassword(encoder.encode("123"));

        User user3 = new User();
        user3.setEmail("user@gmail.com");
        user3.setUserName("mariandiakivUSER");
        HashSet<Role>  roles3 = new HashSet<>();
        roles3.add(roles.get(0));// user
        user3.setRole(roles3);// admin
        user3.setPassword(encoder.encode("123"));

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);

        return userService.findAll();
    }
}
