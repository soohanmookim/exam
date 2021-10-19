package com.example.exam.v1.student.presentation;

import com.example.exam.exception.NoDataException;
import com.example.exam.v1.student.application.StudentService;
import com.example.exam.v1.subject.dto.SubjectResponse;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.exam.exception.InvalidArgumentException;
import com.example.exam.v1.student.domain.StudentRepository;
import com.example.exam.v1.student.domain.entity.Student;
import com.example.exam.v1.student.dto.StudentRequest;
import com.example.exam.v1.student.dto.StudentResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/student")
@RequiredArgsConstructor
public class StudentController {

	private final StudentRepository studentRepository;
	private final StudentService studentService;
	
	@PostMapping
	public ResponseEntity<StudentResponse> add(@RequestBody StudentRequest request) {
		
		return ResponseEntity.ok(
				StudentResponse.of(studentRepository.save(Student.of(request))));
				
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentResponse> findById(@PathVariable long id) {

		return ResponseEntity.ok(
				StudentResponse.of(studentRepository.findById(id)
				.orElseThrow(() -> new NoDataException("존재하지 않는 학생 ID"))));
				
	}

	@DeleteMapping("/{id}")
	@Description("특정 학생 삭제")
	public ResponseEntity<StudentResponse> deleteById(@PathVariable Long id) {

		studentService.deleteById(id);

		return ResponseEntity.noContent().build();
	}
	
}
