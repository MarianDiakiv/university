package com.marian.university.entity;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "\"lesson\"")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "date_lesson")
    @Temporal(TemporalType.DATE)
    private Date datelesson;
    @Column(name = "time_lesson")
    @Temporal(TemporalType.TIME)
    private Date timelesson;
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
}
