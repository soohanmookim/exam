package com.example.exam.v1.student.domain.entity;

import com.example.exam.v1.grade.domain.entity.Grade;
import com.example.exam.v1.student.dto.StudentRequest;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
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

	public void updateAverage() {

		Integer total = Optional.of(getGradeList()).orElseGet(()-> Collections.singletonList(Grade.builder().score(0).build())).stream().mapToInt(Grade::getScore).sum();
		Long count = Optional.of(getGradeList()).orElse(Arrays.asList(new Grade())).stream().count();
		setAverage(BigDecimal.valueOf(total).divide(BigDecimal.valueOf(count), 2, RoundingMode.CEILING));
	}

}
