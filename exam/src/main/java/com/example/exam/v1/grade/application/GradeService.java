package com.example.exam.v1.grade.application;

import com.example.exam.v1.student.application.StudentService;
import com.example.exam.v1.subject.application.SubjectService;
import lombok.extern.slf4j.Slf4j;
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
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class GradeService {

	private final SubjectRepository subjectRepository;
	private final SubjectService subjectService;
	private final StudentRepository studentRepository;
	private final StudentService studentService;
	private final GradeRepository gradeRepository;
	
	public GradeResponse save(Long subjectId, Long studentId, GradeRequest score) {
		Subject subject = subjectService.findById(subjectId);
		Student student = studentService.findById(studentId);

		Grade grade = gradeRepository.save(Grade.builder()
				.subject(subject)
				.student(student)
				.score(score.getScore())
				.build());

		grade.getSubject().updateAverage();
		grade.getSubject().getGradeList().stream().map(Grade::getStudent).collect(Collectors.toList())
				.stream().forEach(student1 -> student1.updateAverage());

		gradeRepository.save(grade);

		return GradeResponse.of(grade);
	}
	
	public GradeResponse updateScore(Long id, GradeRequest score) {
		Grade grade = gradeRepository.findById(id).orElseThrow(() -> new NoDataException("존재하지 않는 성적 ID"));
		grade.setScore(score.getScore());

		grade.getSubject().updateAverage();
		grade.getStudent().updateAverage();

		return GradeResponse.of(gradeRepository.save(grade));
	}
	
	public void delete(Long id) {
		Grade grade = gradeRepository.findById(id).orElseThrow(() -> new NoDataException("존재하지 않는 성적 ID"));
		gradeRepository.deleteById(id);

	}



//	private void updateAverage(Grade grade) {
//		List<Grade> listBySubject = gradeRepository.findBySubject(grade.getSubject());
//		List<Grade> listByStudent = gradeRepository.findByStudent(grade.getStudent());
//
//		Integer total = Optional.of(listBySubject).orElseGet(()-> Collections.singletonList(Grade.builder().score(0).build())).stream().mapToInt(Grade::getScore).sum();
//		Long count = Optional.of(listBySubject).orElse(Arrays.asList(new Grade())).stream().count();
//		grade.getSubject().setAverage(BigDecimal.valueOf(total).divide(BigDecimal.valueOf(count), 2, RoundingMode.CEILING));
//
//		Integer totalStudent = Optional.of(listByStudent).orElseGet(()-> Collections.singletonList(Grade.builder().score(0).build())).stream().mapToInt(Grade::getScore).sum();
//		Long countStudent = Optional.of(listByStudent).orElse(Arrays.asList(new Grade())).stream().count();
//		grade.getStudent().setAverage(BigDecimal.valueOf(totalStudent).divide(BigDecimal.valueOf(countStudent), 2, RoundingMode.CEILING));
//
//	}
	
}
