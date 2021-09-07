package com.example.exam.v1.subject.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.exam.v1.subject.dto.SubjectRequest;
import com.example.exam.v1.subject.dto.SubjectResponse;
import lombok.*;
import org.graalvm.compiler.hotspot.stubs.CreateExceptionStub;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@ToString
@Builder
@Entity
@NoArgsConstructor
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(nullable = false, length = 64)
	private String name;
	
	@Column(scale = 2)
	private BigDecimal average;
	
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@CreationTimestamp
	private LocalDateTime createdAt;

	public static Subject of(SubjectRequest request) {
		return Subject.builder().name(request.getName()).build();
	}
	
}
