package com.marian.university.serviceImpl;

import com.marian.university.entity.TeacherDetail;
import com.marian.university.repository.TeacherDetailRepository;
import com.marian.university.service.TeacherDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherDetailServiceImpl implements TeacherDetailService {
    @Autowired
    private TeacherDetailRepository repository;
    @Override
    public void save(TeacherDetail detail) {
        repository.save(detail);
    }

    @Override
    public TeacherDetail getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public List<TeacherDetail> getAll() {
        return repository.findAll();
    }
}
