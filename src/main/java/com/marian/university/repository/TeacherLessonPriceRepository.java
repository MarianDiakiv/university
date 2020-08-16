package com.marian.university.repository;

import com.marian.university.entity.Subject;
import com.marian.university.entity.TeacherDetail;
import com.marian.university.entity.TeacherLessonPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherLessonPriceRepository extends JpaRepository<TeacherLessonPrice, Integer> {

    @Query("select  t from TeacherLessonPrice  t where t.teacherDetail=:detail")
    List<TeacherLessonPrice> getByTeacherDet( @Param("detail") TeacherDetail detail);
    @Query("select  t from  TeacherLessonPrice t where t.subjectT=:subject")
    List<TeacherLessonPrice> getBySubjec(@Param("subject") Subject subject);
}
