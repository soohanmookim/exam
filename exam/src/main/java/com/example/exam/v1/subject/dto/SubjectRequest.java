package com.example.exam.v1.subject.dto;

import com.example.exam.v1.subject.entity.Subject;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
public class SubjectRequest {

    private Long id;
    private String name;

    public static Subject of(SubjectRequest request) {
        return Subject.builder().name(request.getName()).build();
    }
}
