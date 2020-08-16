package com.marian.university.dto;

import com.marian.university.entity.ERoles;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class RoleDTO extends AbstractDTO {

    @Enumerated(EnumType.STRING)
    private ERoles nameRole;

    public RoleDTO() {
    }

    public RoleDTO(ERoles nameRole) {
        this.nameRole = nameRole;
    }

    public ERoles getNameRole() {
        return nameRole;
    }

    public void setNameRole(ERoles nameRole) {
        this.nameRole = nameRole;
    }
}
