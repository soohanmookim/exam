package com.example.exam.v1.grade.dto;

import com.example.exam.v1.grade.domain.entity.Grade;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GradeResponse {
	
	private Long id;
	private Long subjectId;
	private Long studentId;
	private Integer score;
	
	public static GradeResponse of(Grade grade) {
		return GradeResponse.builder()
				.id(grade.getId())
				.subjectId(grade.getSubject().getId())
				.studentId(grade.getStudent().getId())
				.score(grade.getScore())
				.build();
	}
}
