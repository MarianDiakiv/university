package com.marian.university.repository;

import com.marian.university.entity.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsDetailRepository extends JpaRepository<StudentDetails, Integer> {
}
