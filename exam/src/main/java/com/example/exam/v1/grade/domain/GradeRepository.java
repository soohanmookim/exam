package com.example.exam.v1.grade.domain;

import com.example.exam.v1.grade.domain.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

    List<Grade> findByStudentId(Long studentId);

    List<Grade> findBySubjectId(Long subjectId);

    void deleteByStudentId(Long studentId);

    void deleteBySubjectId(Long subjectId);

}
