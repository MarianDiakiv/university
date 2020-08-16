package com.marian.university.repository;

import com.marian.university.entity.TeacherDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDetailRepository extends JpaRepository<TeacherDetail, Integer> {
}
