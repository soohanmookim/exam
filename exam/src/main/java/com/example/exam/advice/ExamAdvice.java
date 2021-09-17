package com.example.exam.advice;

import com.example.exam.exception.NoDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExamAdvice {

	@ExceptionHandler(value = NoDataException.class)
	public ResponseEntity<ErrorResponse> NoDataExceptionHandler(RuntimeException e) {
		return ResponseEntity.badRequest().body(ErrorResponse.builder().message(e.getMessage()).build());
	}
}
