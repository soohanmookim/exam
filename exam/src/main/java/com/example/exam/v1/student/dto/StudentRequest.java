package com.example.exam.v1.student.dto;

import org.springframework.boot.jackson.JsonComponent;

import lombok.AllArgsConstructor;
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
public class StudentRequest {

	private String name;
}
