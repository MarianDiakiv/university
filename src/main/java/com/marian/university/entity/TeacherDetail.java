package com.marian.university.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "\"teacher_detail\"")
@Table(name = "teacher_detail")
public class TeacherDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    private Subject subject;

    @OneToOne(mappedBy = "teacherDetail")
    private User user;

    @OneToMany(mappedBy = "teacherDetail",fetch = FetchType.LAZY)
    private List<FreeTeachersTime> timeList = new ArrayList<>();


/*    @OneToMany(mappedBy = "teacherDetail"*//*,fetch = FetchType.LAZY*//*)
    private List<FreeTeachersTime> freeTeachersTimes = new ArrayList<>();*/

    @OneToMany( mappedBy = "teacherDetail", fetch = FetchType.LAZY)
    private List<TeacherLessonPrice> teacherLessonPrices = new ArrayList<>();

    @OneToMany(mappedBy = "teacherDetail", fetch = FetchType.LAZY)
    private List<Lesson> lessonList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<FreeTeachersTime> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<FreeTeachersTime> timeList) {
        this.timeList = timeList;
    }

/*    public List<FreeTeachersTime> getFreeTeachersTimes() {
        return freeTeachersTimes;
    }

    public void setFreeTeachersTimes(List<FreeTeachersTime> freeTeachersTimes) {
        this.freeTeachersTimes = freeTeachersTimes;
    }*/

    public List<TeacherLessonPrice> getTeacherLessonPrices() {
        return teacherLessonPrices;
    }

    public void setTeacherLessonPrices(List<TeacherLessonPrice> teacherLessonPrices) {
        this.teacherLessonPrices = teacherLessonPrices;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public TeacherDetail() {
    }
}
