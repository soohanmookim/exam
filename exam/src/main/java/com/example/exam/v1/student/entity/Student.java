package com.example.exam.v1.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.exam.v1.student.dto.StudentRequest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name = "name", nullable = false, length = 32)
	private String name;
	
	public static Student of(StudentRequest request) {
		return Student.builder()
				.name(request.getName())
				.build();
	}

}
