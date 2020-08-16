package com.marian.university.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TeacherLessonPriceDTO extends AbstractDTO {
    @NotNull
    private int time;//minutes;
    @NotNull
    private BigDecimal price;
    @NotNull
    private  int teacherDetailsId;
    @NotNull
    private int subjectid;

    public TeacherLessonPriceDTO() {
    }

    public TeacherLessonPriceDTO(@NotNull int time, @NotNull BigDecimal price, @NotNull int teacherDetailsId, @NotNull int subjectid) {
        this.time = time;
        this.price = price;
        this.teacherDetailsId = teacherDetailsId;
        this.subjectid = subjectid;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getTeacherDetailsId() {
        return teacherDetailsId;
    }

    public void setTeacherDetailsId(int teacherDetailsId) {
        this.teacherDetailsId = teacherDetailsId;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }
}
