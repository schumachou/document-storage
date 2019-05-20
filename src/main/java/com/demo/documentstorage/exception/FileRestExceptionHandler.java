package com.demo.documentstorage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FileRestExceptionHandler {
	
	// Exception handler for MyFileNotFoundException
	@ExceptionHandler
	public ResponseEntity<FileErrorResponse> handleException(MyFileNotFoundException e){
		FileErrorResponse error = new FileErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	// Exception handler to catch any other exception
	@ExceptionHandler
	public ResponseEntity<FileErrorResponse> handleException(Exception e){
		FileErrorResponse error = new FileErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
