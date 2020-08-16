package com.marian.university.serviceImpl;

import com.marian.university.entity.Subject;
import com.marian.university.repository.SubjectRepository;
import com.marian.university.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository repository;
    @Override
    public List<Subject> getAll() {
        return repository.findAll();
    }

    @Override
    public Subject getBuId(int id) {
        return repository.getOne(id);
    }

    @Override
    public void save(Subject subject) {
        repository.save(subject);
    }

    @Override
    public Subject getSubjectByName(String name) {
        return repository.getSubjectByName(name);
    }
}
