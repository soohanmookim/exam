package com.example.exam.exception;

import org.springframework.http.HttpStatus;

public class ExamException extends RuntimeException {

	HttpStatus httpStatus;
}
