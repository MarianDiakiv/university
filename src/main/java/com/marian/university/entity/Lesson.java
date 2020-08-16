package com.marian.university.entity;



import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "\"lesson\"")
@Table(name = "lesson")
public class Lesson {
    // доробити початок і кінець уроку
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "date_lesson")
    @Temporal(TemporalType.DATE)
    private Date datelesson;
    @Column(name = "time_lesson")
    @Temporal(TemporalType.TIME)
    private Date timelesson;
    @Column(name="time_lesson_end")
    @Temporal(TemporalType.TIME)
    private Date timeLessonEnd;
    @Column(name = "status_lesson")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "student_details_id")
    private StudentDetails studentDetails;

    @ManyToOne
    @JoinColumn(name = "teacher_detail_id")
    private TeacherDetail teacherDetail;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject  subject;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatelesson() {
        return datelesson;
    }

    public void setDatelesson(Date datelesson) {
        this.datelesson = datelesson;
    }

    public Date getTimelesson() {
        return timelesson;
    }

    public void setTimelesson(Date timelesson) {
        this.timelesson = timelesson;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public StudentDetails getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(StudentDetails studentDetails) {
        this.studentDetails = studentDetails;
    }

    public TeacherDetail getTeacherDetail() {
        return teacherDetail;
    }

    public void setTeacherDetail(TeacherDetail teacherDetail) {
        this.teacherDetail = teacherDetail;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getTimeLessonEnd() {
        return timeLessonEnd;
    }

    public void setTimeLessonEnd(Date timeLessonEnd) {
        this.timeLessonEnd = timeLessonEnd;
    }

    public Lesson() {
    }
}
