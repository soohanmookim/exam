package com.example.exam.v1.student.domain.entity;

import com.example.exam.v1.grade.domain.entity.Grade;
import com.example.exam.v1.student.dto.StudentRequest;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@ToString
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(nullable = false, length = 32)
	private String name;
	
	@Column(scale = 2)
	@ColumnDefault(value = "0")
	private BigDecimal average;

	@OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE)
	private List<Grade> gradeList;
	
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@CreationTimestamp
	private LocalDateTime createdAt;
	
	public static Student of(StudentRequest request) {
		return Student.builder()
				.name(request.getName())
				.build();
	}

}
