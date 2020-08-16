package com.marian.university.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
/*@Table(name="\"free_teachers_time\"")*/
@Table(name = "free_teachers_time")
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
//    @Temporal(Te)
//    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="teacher_details_id")
    private TeacherDetail teacherDetail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatestart() {
        return datestart;
    }

    public void setDatestart(Date datestart) {
        this.datestart = datestart;
    }

    public Date getDateend() {
        return dateend;
    }

    public void setDateend(Date dateend) {
        this.dateend = dateend;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeend() {
        return timeend;
    }

    public void setTimeend(Date timeend) {
        this.timeend = timeend;
    }

    public TeacherDetail getTeacherDetail() {
        return teacherDetail;
    }

    public void setTeacherDetail(TeacherDetail teacherDetail) {
        this.teacherDetail = teacherDetail;
    }

    public FreeTeachersTime() {
    }
}
