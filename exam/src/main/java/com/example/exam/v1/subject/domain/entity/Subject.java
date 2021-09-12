package com.example.exam.v1.subject.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.exam.v1.subject.dto.SubjectRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(nullable = false, length = 64)
	private String name;
	
	@Column(scale = 2)
	@ColumnDefault(value = "0")
	private BigDecimal average;
	
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@CreationTimestamp
	private LocalDateTime createdAt;

	public static Subject of(SubjectRequest request) {
		return Subject.builder().name(request.getName()).build();
	}
	
}
