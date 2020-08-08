package com.marian.university.entity;

import javax.persistence.*;

@Entity
@Table(name="\"roles\"")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column
    private ERoles nameRole;

    public Role(ERoles nameRole) {
        this.nameRole = nameRole;
    }

    public Role() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERoles getNameRole() {
        return nameRole;
    }

    public void setNameRole(ERoles nameRole) {
        this.nameRole = nameRole;
    }
}
