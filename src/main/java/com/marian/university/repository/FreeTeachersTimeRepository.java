package com.marian.university.repository;

import com.marian.university.entity.FreeTeachersTime;
import com.marian.university.entity.TeacherDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FreeTeachersTimeRepository extends JpaRepository<FreeTeachersTime, Integer> {
    @Query("select f from FreeTeachersTime f where f.teacherDetail =:detail")
    List<FreeTeachersTime> getByTeacherDetail( @Param("detail") TeacherDetail detail);
    @Query("select f from FreeTeachersTime f where  f.teacherDetail = :detail and f.datestart<=:dates and f.dateend>=:dates and f.timeStart<=:time " +
            "and f.timeend>=:timed")
   List<FreeTeachersTime> getByTeacherDetailsAndDay(@Param("detail")TeacherDetail detail,
                                                    @Param("dates") Date dates,
                                                    @Param("time") Date time,
                                                    @Param("timed") Date timed);

}
