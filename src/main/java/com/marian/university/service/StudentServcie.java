package com.marian.university.service;

import com.marian.university.entity.StudentDetails;
import com.marian.university.entity.Subject;

import java.util.List;

public interface StudentServcie {
    void save(StudentDetails studentDetails);
    StudentDetails getById(int id);
    List<StudentDetails> getAll();

}
