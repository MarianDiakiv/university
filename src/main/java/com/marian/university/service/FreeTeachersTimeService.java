package com.marian.university.service;

import com.marian.university.entity.FreeTeachersTime;
import com.marian.university.entity.TeacherDetail;

import java.util.Date;
import java.util.List;

public interface FreeTeachersTimeService  {
    void save(FreeTeachersTime time);
    FreeTeachersTime getBuId(int id);
    List<FreeTeachersTime> getAll();
    List<FreeTeachersTime> getByTeacherDetails(TeacherDetail detail);
    List<FreeTeachersTime> getByTeacherDetailsAndDay(TeacherDetail detail,Date dates, Date time,Date timed);

}
