package com.example.exam.v1.grade.application;

import org.springframework.stereotype.Service;

import com.example.exam.exception.NoDataException;
import com.example.exam.v1.grade.domain.GradeRepository;
import com.example.exam.v1.grade.domain.entity.Grade;
import com.example.exam.v1.grade.dto.GradeDeleteResponse;
import com.example.exam.v1.grade.dto.GradeRequest;
import com.example.exam.v1.grade.dto.GradeResponse;
import com.example.exam.v1.student.domain.StudentRepository;
import com.example.exam.v1.student.domain.entity.Student;
import com.example.exam.v1.subject.domain.SubjectRepository;
import com.example.exam.v1.subject.domain.entity.Subject;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GradeService {

	private final SubjectRepository subjectRepository;
	private final StudentRepository studentRepository;
	private final GradeRepository gradeRepository;
	
	public GradeResponse save(Long subjectId, Long studentId, GradeRequest score) {
		subjectRepository.findById(subjectId).orElseThrow(() -> new NoDataException("존재하지 않는 과목 ID"));
		studentRepository.findById(studentId).orElseThrow(() -> new NoDataException("존재하지 않는 학생 ID"));
		
		return GradeResponse.of(gradeRepository.save(Grade.builder()
				.subject(Subject.builder().id(subjectId).build())
				.student(Student.builder().id(studentId).build())
				.score(score.getScore())
				.build()));
	}
	
	public GradeResponse updateScore(Long id, GradeRequest score) {
		Grade grade = gradeRepository.findById(id).orElseThrow(() -> new NoDataException("존재하지 않는 성적 ID"));
		grade.setScore(score.getScore());
		return GradeResponse.of(gradeRepository.save(grade));
	}
	
	public GradeDeleteResponse delete(Long id) {
		gradeRepository.delete(gradeRepository.findById(id).orElseThrow(() -> new NoDataException("존재하지 않는 성적 ID")));
		return GradeDeleteResponse.builder().id(id).build();
	}
	
}
