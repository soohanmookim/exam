package com.example.exam.v1.grade.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exam.v1.grade.application.GradeService;
import com.example.exam.v1.grade.dto.GradeDeleteResponse;
import com.example.exam.v1.grade.dto.GradeRequest;
import com.example.exam.v1.grade.dto.GradeResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/grade")
@RequiredArgsConstructor
public class GradeController {
 
	private final GradeService gradeService;
	

	@PostMapping("/subject/{subjectId}/student/{studentId}")
	public ResponseEntity<GradeResponse> add(@PathVariable(name ="subjectId") Long subjectId, @PathVariable(name ="studentId" ) Long studentId, @RequestBody GradeRequest request) {
		
		log.info("subjectId {}, studentId {}, request {}", subjectId, studentId, request);
		
		return ResponseEntity.ok(gradeService.save(subjectId, studentId, request));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GradeResponse> update(@PathVariable Long id, @RequestBody GradeRequest request) {
		return ResponseEntity.ok(gradeService.updateScore(id, request));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<GradeDeleteResponse> delete(@PathVariable Long id) {
		gradeService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
