package com.marian.university.dto;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class TeacherDetailsDTO extends AbstractDTO {
    @NotNull
    private int userId;
//    private List<LessonDTO> lessonDTOS  = new ArrayList<>();

    public TeacherDetailsDTO(@NotNull int userId) {
        this.userId = userId;
    }


/*    public TeacherDetailsDTO(@NotNull int userId, List<LessonDTO> lessonDTOS) {
        this.userId = userId;
        this.lessonDTOS = lessonDTOS;
    }*/

    public TeacherDetailsDTO() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

   /* public List<LessonDTO> getLessonDTOS() {
        return lessonDTOS;
    }

    public void setLessonDTOS(List<LessonDTO> lessonDTOS) {
        this.lessonDTOS = lessonDTOS;
    }*/
}
