package com.marian.university.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class AbstractDTO implements Serializable {
    @NotNull
    private Integer id;

    public AbstractDTO() {
    }

    public AbstractDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
