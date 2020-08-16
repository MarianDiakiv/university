package com.marian.university.mapper;

import com.marian.university.dto.UserEntityDTO;
import com.marian.university.entity.StudentDetails;
import com.marian.university.entity.TeacherDetail;
import com.marian.university.entity.User;
import com.marian.university.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper {
    @Autowired
    private UserRepository userRepository;

    public UserEntityDTO userToDto(User user){
        UserEntityDTO dto = new UserEntityDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setPassword("*******"); //закритий пароль
//        dto.setPassword(user.getPassword());
        dto.setUserName(user.getUserName());
        RoleMapper roleMapper = new RoleMapper();
        dto.setRoleDTOS(roleMapper.roleToDto(user.getRole()));

        StudentDetails studentDetails = user.getStudentDetails();

        if(studentDetails!=null){
            dto.setStudentDetailId(user.getStudentDetails().getId());
        }else {
            dto.setStudentDetailId(0);
        }

        TeacherDetail teacherDetail = user.getTeacherDetail();
        if (teacherDetail!=null){
            dto.setTeacherDetailID(user.getTeacherDetail().getId());
        }else {
            dto.setTeacherDetailID(0);
        }

        return dto;
    }
    public User dtoToEntity(UserEntityDTO dto){
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPassword(userRepository.getOne(dto.getId()).getPassword()); //отримуємо пароль із бази
        user.setUserName(dto.getUserName());
        RoleMapper roleMapper = new RoleMapper();
        user.setRole(roleMapper.dtoToEntity(dto.getRoleDTOS()));
        // додати лісти


        return user;
    }
}
