package com.marian.university.dto;

import javax.validation.constraints.NotNull;

public class SubjectDTO extends AbstractDTO {
    @NotNull
    private String nameSubject;

    public SubjectDTO() {
    }

    public SubjectDTO(@NotNull String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }
}
