package com.example.exam.advice;

import com.example.exam.exception.NoDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exam.exception.InvalidArgumentException;

@RestControllerAdvice
public class ExamAdvice {

	@ExceptionHandler(value = NoDataException.class)
	public ResponseEntity<HttpStatus> NoDataExceptionHandler(RuntimeException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
