package com.marian.university.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"teacher_detail\"")
public class TeacherDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    private Subject subject;

    @OneToOne(mappedBy = "teacherDetail")
    private User user;

    @OneToMany(mappedBy = "teacherDetail"/*,fetch = FetchType.LAZY*/)
    private List<FreeTeachersTime> freeTeachersTimes = new ArrayList<>();

    @OneToMany( mappedBy = "teacherDetail", fetch = FetchType.LAZY)
    private List<TeacherLessonPrice> teacherLessonPrices = new ArrayList<>();

    @OneToMany(mappedBy = "teacherDetail", fetch = FetchType.LAZY)
    private List<Lesson> lessonList = new ArrayList<>();

}
