package com.example.exam.v1.student.entity;

import com.example.exam.v1.student.dto.StudentRequest;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@Entity
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(nullable = false, length = 32)
	private String name;
	
	public static Student of(StudentRequest request) {
		return Student.builder()
				.name(request.getName())
				.build();
	}

}
