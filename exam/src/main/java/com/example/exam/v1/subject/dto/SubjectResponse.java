package com.example.exam.v1.subject.dto;

import com.example.exam.v1.subject.entity.Subject;
import lombok.*;
import org.springframework.boot.jackson.JsonComponent;

import java.math.BigDecimal;

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
