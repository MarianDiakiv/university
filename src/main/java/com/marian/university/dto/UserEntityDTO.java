package com.marian.university.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class UserEntityDTO extends AbstractDTO{

    @NotNull
    private String userName;
@NotNull
@Email
    private String email;
    @JsonIgnore// можлво треба буде забрати
    private String password;
    @NotNull
    private int teacherDetailID;
    @NotNull
    private int studentDetailId;
    private  Set<RoleDTO> roleDTOS = new HashSet<>();

    public UserEntityDTO() {
    }

    public UserEntityDTO(@NotNull String userName, @NotNull @Email String email, String password, @NotNull int teacherDetailID, @NotNull int studentDetailId, Set<RoleDTO> roleDTOS) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.teacherDetailID = teacherDetailID;
        this.studentDetailId = studentDetailId;
        this.roleDTOS = roleDTOS;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTeacherDetailID() {
        return teacherDetailID;
    }

    public void setTeacherDetailID(int teacherDetailID) {
        this.teacherDetailID = teacherDetailID;
    }

    public int getStudentDetailId() {
        return studentDetailId;
    }

    public void setStudentDetailId(int studentDetailId) {
        this.studentDetailId = studentDetailId;
    }

    public Set<RoleDTO> getRoleDTOS() {
        return roleDTOS;
    }

    public void setRoleDTOS(Set<RoleDTO> roleDTOS) {
        this.roleDTOS = roleDTOS;
    }
}
