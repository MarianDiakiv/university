package com.marian.university.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class LessonDTO extends AbstractDTO {

//    @Temporal(TemporalType.DATE)
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date datelesson;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date timelesson;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date timeLessonEnd;
    @NotNull
    @JsonIgnore// можливо потрібно буде забрати
    private boolean status;
    @NotNull
    private int studentDetailsId;
    @NotNull
    private int teacherDetailsId;
    @NotNull
    private int subjectId;

    public LessonDTO() {
    }

    public LessonDTO(@NotNull Date datelesson, @NotNull Date timelesson, Date timeLessonEnd, @NotNull boolean status, @NotNull int studentDetailsId, @NotNull int teacherDetailsId, @NotNull int subjectId) {
        this.datelesson = datelesson;
        this.timelesson = timelesson;
        this.timeLessonEnd = timeLessonEnd;
        this.status = status;
        this.studentDetailsId = studentDetailsId;
        this.teacherDetailsId = teacherDetailsId;
        this.subjectId = subjectId;
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

    public int getStudentDetailsId() {
        return studentDetailsId;
    }

    public void setStudentDetailsId(int studentDetailsId) {
        this.studentDetailsId = studentDetailsId;
    }

    public int getTeacherDetailsId() {
        return teacherDetailsId;
    }

    public void setTeacherDetailsId(int teacherDetailsId) {
        this.teacherDetailsId = teacherDetailsId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public Date getTimeLessonEnd() {
        return timeLessonEnd;
    }

    public void setTimeLessonEnd(Date timeLessonEnd) {
        this.timeLessonEnd = timeLessonEnd;
    }
}
