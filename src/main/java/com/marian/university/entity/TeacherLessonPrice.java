package com.marian.university.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
//@Table(name = "\"teacher_lesson_price\"")
@Table(name = "teacher_lesson_price")
public class TeacherLessonPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int tyme;// minutes;
    @Column(name="price",columnDefinition = "DECIMAL(5,2)")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="teacher_detail_id")
    private TeacherDetail  teacherDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subjectT;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTyme() {
        return tyme;
    }

    public void setTyme(int tyme) {
        this.tyme = tyme;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TeacherDetail getTeacherDetail() {
        return teacherDetail;
    }

    public void setTeacherDetail(TeacherDetail teacherDetail) {
        this.teacherDetail = teacherDetail;
    }

    public Subject getSubjectT() {
        return subjectT;
    }

    public void setSubjectT(Subject subjectT) {
        this.subjectT = subjectT;
    }

    public TeacherLessonPrice() {
    }
}
