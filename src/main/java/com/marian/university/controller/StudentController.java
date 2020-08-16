package com.marian.university.controller;

import com.marian.university.dto.SubjectDTO;
import com.marian.university.dto.UserEntityDTO;
import com.marian.university.entity.Subject;
import com.marian.university.entity.User;
import com.marian.university.mapper.SubjectMapper;
import com.marian.university.mapper.UserMapper;
import com.marian.university.service.SubjectService;
import com.marian.university.service.TeacherLessonPriceService;
import com.marian.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/open")
public class StudentController {
//    private

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherLessonPriceService priceService;
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/getAllTeacher")
    public List<UserEntityDTO> getAllTeacher(){
        List<User> list = userService.getAllTeacher();
        ArrayList<UserEntityDTO> dtos = new ArrayList<>();
        UserMapper mapper = new UserMapper();
        for (User u :list){
            UserEntityDTO dto = mapper.userToDto(u);
            dtos.add(dto);
        }
        return dtos;
}
@GetMapping("/getTeacherBySubject/{nameSubject}")
public List<UserEntityDTO> getTeacherBySubjectName(@PathVariable("nameSubject") String nameSubject){
    Subject s  = subjectService.getSubjectByName(nameSubject);
        List<User> list = priceService.getBySubject(s);
        ArrayList<UserEntityDTO> dtos = new ArrayList<>();
        UserMapper userMapper = new UserMapper();
        for (User u :list){
            UserEntityDTO entityDTO = userMapper.userToDto(u);
            dtos.add(entityDTO);
        }
        return dtos;


}


}
