package com.marian.university.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="\"free_teachers_time\"")
public class FreeTeachersTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="date_start")
    @Temporal(TemporalType.DATE)
    private Date datestart;
    @Column(name="date_end")
    @Temporal(TemporalType.DATE)
    private Date dateend;
    @Column(name="time_start")
    @Temporal(TemporalType.TIME)
    private Date timeStart;
    @Column(name="time_end")
    @Temporal(TemporalType.TIME)
    private Date timeend;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="teacher_details_id")
    private TeacherDetail teacherDetail;
}
