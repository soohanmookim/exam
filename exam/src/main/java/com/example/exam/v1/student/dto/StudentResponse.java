package com.example.exam.v1.student.dto;

import org.springframework.boot.jackson.JsonComponent;

import com.example.exam.v1.student.domain.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonComponent
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
	
	private long id;
	private String name;

	public static StudentResponse of(Student student) {
		
		return StudentResponse.builder()
				.id(student.getId())
				.name(student.getName())
				.build();
	}
}
