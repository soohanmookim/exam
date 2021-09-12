package com.example.exam.v1.subject.dto;

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
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SubjectRequest {

    private Long id;
    private String name;

    public static Subject of(SubjectRequest request) {
        return Subject.builder().name(request.getName()).build();
    }
}
