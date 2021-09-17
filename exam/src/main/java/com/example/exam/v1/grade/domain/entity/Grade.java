package com.example.exam.v1.grade.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.exam.v1.student.domain.entity.Student;
import com.example.exam.v1.subject.domain.entity.Subject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    
    @ManyToOne
    private Student student;
    
    @ManyToOne
    private Subject subject;
    
    @ColumnDefault(value = "0")
    private Integer score;
    
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@CreationTimestamp
	private LocalDateTime createdAt;
    

}
