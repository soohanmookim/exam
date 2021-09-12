package com.example.exam.v1.student.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.exam.v1.student.domain.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	//Student findById(long id);
}
