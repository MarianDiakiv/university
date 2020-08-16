package com.marian.university.entity;

import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name="\"users\"", uniqueConstraints = {@UniqueConstraint(columnNames = "username"),
//@UniqueConstraint(columnNames = "email")})
@Table(name = "users",uniqueConstraints = {@UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;

    @Column(name = "username")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name="password")
//    @Size(max = 100)
    private String password;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> role = new HashSet<>();

    public User(String userName, String email, @Size(max = 100) String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;

    }
    @OneToOne
    @JoinColumn(name="teacher_details_id")
    private TeacherDetail teacherDetail;

    @OneToOne
    @JoinColumn(name = "student_details_id")
    private StudentDetails studentDetails;



    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public TeacherDetail getTeacherDetail() {
        return teacherDetail;
    }

    public void setTeacherDetail(TeacherDetail teacherDetail) {
        this.teacherDetail = teacherDetail;
    }

    public StudentDetails getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(StudentDetails studentDetails) {
        this.studentDetails = studentDetails;
    }
}
