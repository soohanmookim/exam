package com.example.exam.v1.student.presentation;

import com.example.exam.exception.NoDataException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
