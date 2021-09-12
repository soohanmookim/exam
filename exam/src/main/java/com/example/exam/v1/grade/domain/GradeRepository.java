package com.example.exam.v1.grade.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.exam.v1.grade.domain.entity.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
}
