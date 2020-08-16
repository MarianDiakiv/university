package com.marian.university.service;

import com.marian.university.entity.TeacherDetail;

import java.util.List;

public interface TeacherDetailService {
    void save(TeacherDetail detail);
    TeacherDetail getById(int id);
    List<TeacherDetail> getAll();

}
