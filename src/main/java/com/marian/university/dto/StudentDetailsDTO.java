package com.marian.university.dto;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.ArrayList;
public class StudentDetailsDTO extends  AbstractDTO {
    @NotNull
    private int userId;
//    private List<LessonDTO> lessonDTOS = new ArrayList<>();

 /*   public StudentDetailsDTO(@NotNull int userId, List<LessonDTO> lessonDTOS) {
        this.userId = userId;
        this.lessonDTOS = lessonDTOS;
    }*/

    public StudentDetailsDTO(@NotNull int userId) {
        this.userId = userId;
    }

    public StudentDetailsDTO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

/*    public List<LessonDTO> getLessonDTOS() {
        return lessonDTOS;
    }

    public void setLessonDTOS(List<LessonDTO> lessonDTOS) {
        this.lessonDTOS = lessonDTOS;
    }*/
}
