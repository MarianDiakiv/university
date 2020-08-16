package com.marian.university.repository;

import com.marian.university.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    @Query("Select s from Subject  s where s.namesubject=:name")
    Subject getSubjectByName(@Param("name") String name);
}
