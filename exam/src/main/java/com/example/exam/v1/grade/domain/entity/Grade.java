package com.example.exam.v1.grade.domain.entity;

import com.example.exam.v1.student.domain.entity.Student;
import com.example.exam.v1.subject.domain.entity.Subject;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@ToString
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
