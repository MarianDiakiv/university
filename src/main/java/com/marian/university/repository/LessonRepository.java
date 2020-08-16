package com.marian.university.repository;

import com.marian.university.entity.Lesson;
import com.marian.university.entity.TeacherDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    @Query("select l from Lesson  l where l.teacherDetail=:detail")
public List<Lesson> getLessonByTeacherDetail(@Param("detail") TeacherDetail detail);
    @Query("select  l from Lesson  l where l.teacherDetail=:detail and l.datelesson =:date " +
            "and l.timelesson<=:times and l.timeLessonEnd>=:timed ")
    public List<Lesson> getLessonByTeacherDetailAndAndTimelesson(@Param("detail") TeacherDetail detail,
                                                                 @Param("date") Date date,
                                                                 @Param("times") Date times,
                                                                 @Param("timed") Date timed);
//    public List<Lesson> getLessonByTeacherDetailDateTime()

    @Query("SELECT  l from Lesson  l where l.teacherDetail=:detail and l.status=:status")
    List<Lesson> getLessonByTeacherDetailAndStatus(@Param("detail") TeacherDetail detail,@Param("status") boolean status);

}
