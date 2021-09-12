package com.example.exam.v1.subject.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exam.v1.subject.domain.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
