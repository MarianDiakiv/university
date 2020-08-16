package com.marian.university.serviceImpl;

import com.marian.university.entity.StudentDetails;
import com.marian.university.repository.StudentsDetailRepository;
import com.marian.university.service.StudentServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentServcie {

    @Autowired
    private StudentsDetailRepository repository;
    @Override
    public void save(StudentDetails studentDetails) {
        repository.save(studentDetails);
    }

    @Override
    public StudentDetails getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public List<StudentDetails> getAll() {
        return repository.findAll();
    }
}
