package com.marian.university.serviceImpl;

import com.marian.university.entity.Subject;
import com.marian.university.entity.TeacherDetail;
import com.marian.university.entity.TeacherLessonPrice;
import com.marian.university.entity.User;
import com.marian.university.repository.TeacherLessonPriceRepository;
import com.marian.university.service.TeacherLessonPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherLessonPriceServiceImpl implements TeacherLessonPriceService {

    @Autowired
    private TeacherLessonPriceRepository repository;
    @Override
    public void save(TeacherLessonPrice price) {
        repository.save(price);
    }

    @Override
    public TeacherLessonPrice getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public List<TeacherLessonPrice> getAll() {
        return repository.findAll();
    }

    @Override
    public List<TeacherLessonPrice> getByTeacher(TeacherDetail detail) {
        return repository.getByTeacherDet(detail);
    }

    @Override
    public List<User> getBySubject(Subject subject) {
        List<TeacherLessonPrice> prices = repository.getBySubjec(subject);
        ArrayList<User> users = new ArrayList<>();
        for (TeacherLessonPrice p: prices){
            User user = p.getTeacherDetail().getUser();
            users.add(user);
        }
        return users;
    }
}
