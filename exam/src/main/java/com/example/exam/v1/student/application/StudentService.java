package com.example.exam.v1.student.application;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.example.exam.v1.grade.domain.GradeRepository;
import com.example.exam.v1.student.domain.StudentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentService {

	private final StudentRepository studentRepository;
	private final GradeRepository gradeRepository;
	
	public void updateAverage(Long id) {
		
	}
	
}
