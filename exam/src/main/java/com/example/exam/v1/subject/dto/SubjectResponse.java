package com.example.exam.v1.subject.dto;

import java.math.BigDecimal;

import org.springframework.boot.jackson.JsonComponent;

import com.example.exam.v1.subject.domain.entity.Subject;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectResponse {

    private long id;
    private String name;
    private BigDecimal average;

    public static SubjectResponse of(Subject subject) {
        return SubjectResponse.builder()
                .id(subject.getId())
                .name(subject.getName())
                .average(subject.getAverage())
                .build();
    }
}
