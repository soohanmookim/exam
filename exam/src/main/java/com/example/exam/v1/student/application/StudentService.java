package com.example.exam.v1.student.application;

import java.math.BigDecimal;

import com.example.exam.v1.grade.domain.entity.Grade;
import com.example.exam.v1.student.domain.entity.Student;
import org.springframework.stereotype.Service;

import com.example.exam.v1.grade.domain.GradeRepository;
import com.example.exam.v1.student.domain.StudentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class StudentService {

	private final StudentRepository studentRepository;
	private final GradeRepository gradeRepository;
	
	public void updateAverage(Student student) {
		//student.getGradeList().stream().map(Grade::getScore)
	}
	
}
