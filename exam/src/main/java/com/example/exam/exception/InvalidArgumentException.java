package com.example.exam.exception;

import org.springframework.http.HttpStatus;

public class InvalidArgumentException extends RuntimeException {

	HttpStatus httpStatus;
}
