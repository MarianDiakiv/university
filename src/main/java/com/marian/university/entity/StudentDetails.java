package com.marian.university.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"student_details\"")
public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @OneToOne(mappedBy = "studentDetails")
    private User user;

    @OneToMany(mappedBy = "studentDetails", fetch = FetchType.LAZY)
    private List<Lesson> lessonList = new ArrayList<>();
}
