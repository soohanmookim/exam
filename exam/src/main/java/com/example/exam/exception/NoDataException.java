package com.example.exam.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class NoDataException extends RuntimeException {

	private String message;

}
