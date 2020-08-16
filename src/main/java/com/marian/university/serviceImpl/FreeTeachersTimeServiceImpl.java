package com.marian.university.serviceImpl;

import com.marian.university.entity.FreeTeachersTime;
import com.marian.university.entity.TeacherDetail;
import com.marian.university.repository.FreeTeachersTimeRepository;
import com.marian.university.service.FreeTeachersTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FreeTeachersTimeServiceImpl implements FreeTeachersTimeService {
    @Autowired
    private FreeTeachersTimeRepository repository;
    @Override
    public void save(FreeTeachersTime time) {
        repository.save(time);
    }

    @Override
    public FreeTeachersTime getBuId(int id) {
        return repository.getOne(id);
    }

    @Override
    public List<FreeTeachersTime> getAll() {
        return repository.findAll();
    }

    @Override
    public List<FreeTeachersTime> getByTeacherDetails(TeacherDetail detail) {
        return repository.getByTeacherDetail(detail);
    }

    @Override
    public List<FreeTeachersTime> getByTeacherDetailsAndDay(TeacherDetail detail, Date dates, Date time, Date timed) {
        return repository.getByTeacherDetailsAndDay(detail,dates,time,timed);
    }
}
