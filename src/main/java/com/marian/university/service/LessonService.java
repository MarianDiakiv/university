package com.marian.university.service;

import com.marian.university.entity.Lesson;
import com.marian.university.entity.TeacherDetail;
import com.marian.university.payload.responce.MessageResponse;


import java.util.Date;
import java.util.List;

public interface LessonService {
    MessageResponse save(Lesson lesson);
    Lesson getById(int id);
    List<Lesson> getAll();
    List<Lesson> getLessonByTeacherDetail(TeacherDetail detail);
    List<Lesson>getLessonByTeacherDetailAndAndTimelesson( TeacherDetail detail, Date date, Date times, Date timed);
    List<Lesson> getLessonByTeacherDetailAndStatus( TeacherDetail detail, boolean status);
    MessageResponse update(Lesson lesson);

}
