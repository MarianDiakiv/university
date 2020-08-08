package com.marian.university;

import com.marian.university.entity.ERoles;
import com.marian.university.entity.Role;
import com.marian.university.entity.User;
import com.marian.university.repository.UserRepository;
import com.marian.university.serviceImpl.RoleServiceImpl;
import com.marian.university.serviceImpl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class UniversityApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
        System.out.println("1");
        // create Roles
       /* Role role = new Role();
        role.setNameRole(ERoles.ROLE_USER);
        RoleServiceImpl roleService = new RoleServiceImpl();
        roleService.save(role);
        Role role1 = new Role();
        role1.setNameRole(ERoles.ROLE_TEACHER);
        roleService.save(role1);

        Role role2 = new Role();
        role2.setNameRole(ERoles.ROLE_ADMIN);
        roleService.save(role1);*/

//        User user = new User("marian","mariandiakiv@gmail.com","123456789");
//        user.setRole(new HashSet<>().a);
//        UserServiceImpl service = new UserServiceImpl();
//        service.save(user);

    }

}
