package com.marian.university.controller;

import com.marian.university.dto.UserEntityDTO;
import com.marian.university.entity.*;
import com.marian.university.mapper.UserMapper;
import com.marian.university.repository.RoleRepository;
import com.marian.university.service.RoleService;
import com.marian.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
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
        System.out.println(role.getNameRole().toString());

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
        user3.setRole(roles3);//
        user3.setPassword(encoder.encode("123"));

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);

        return userService.findAll();
    }

    public String craetetestData(){
        User user1 = userService.getOne(1);
        User user2 = userService.getOne(2);
        User user3 = userService.getOne(3);
        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setUser(user3);
        TeacherDetail teacherDetail = new TeacherDetail();
        teacherDetail.setUser(user2);

        Subject math = new Subject();
        math.setNamesubject("Math");
        Lesson lesson = new Lesson();
        lesson.setSubject(math);
        lesson.setStudentDetails(studentDetails);
        lesson.setTeacherDetail(teacherDetail);
        lesson.setDatelesson(new Date());
//        Date date =  LocalDateTime.parse("2020-08-10T06:30:30");
//        lesson.setTimelesson(new Date().);


//        TeacherDetail teacherDetail = new TeacherDetail();

        return "OK";
    }
    @GetMapping("/api/open/getUser")
    public UserEntityDTO getUser(){
        UserMapper userMapper = new UserMapper();
        UserEntityDTO dto = userMapper.userToDto(userService.getOne(1));
        return dto;
    }

/*    @GetMapping("/api/open/getUser")
    public User getUser(){

        return userService.getOne(1);
    }*/
}
