package com.marian.university.service;

import com.marian.university.entity.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAll();
    Subject getBuId(int id);
    void save(Subject subject);
    Subject getSubjectByName(String name);

}
