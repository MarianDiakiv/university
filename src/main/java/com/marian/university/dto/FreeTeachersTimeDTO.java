package com.marian.university.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class FreeTeachersTimeDTO extends AbstractDTO {

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date datestart;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateend;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date timeStart;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Date timeend;
    @NotNull
    private int teacherDetailsId;

    public FreeTeachersTimeDTO(@NotNull Date datestart, @NotNull Date dateend, @NotNull Date timeStart, @NotNull Date timeend, @NotNull int teacherDetailsId) {
        this.datestart = datestart;
        this.dateend = dateend;
        this.timeStart = timeStart;
        this.timeend = timeend;
        this.teacherDetailsId = teacherDetailsId;
    }

    public FreeTeachersTimeDTO() {
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

    public int getTeacherDetailsId() {
        return teacherDetailsId;
    }

    public void setTeacherDetailsId(int teacherDetailsId) {
        this.teacherDetailsId = teacherDetailsId;
    }
}
