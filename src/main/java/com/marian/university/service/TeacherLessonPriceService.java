package com.marian.university.service;

import com.marian.university.entity.Subject;
import com.marian.university.entity.TeacherDetail;
import com.marian.university.entity.TeacherLessonPrice;
import com.marian.university.entity.User;

import java.util.List;

public interface TeacherLessonPriceService {
    void save(TeacherLessonPrice price);
    TeacherLessonPrice getById(int id);
    List<TeacherLessonPrice> getAll();
    List<TeacherLessonPrice> getByTeacher(TeacherDetail detail);
    List<User> getBySubject(Subject subject);
}
