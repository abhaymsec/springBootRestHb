package com.candidjava.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.candidjava.spring.bean.ExceptionResponse;

@ControllerAdvice
public class ExceptionHandlerGlobal extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> NotFoundExceptionHandler(ResourceNotFoundException error){
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMsg(error.getErrorMsg());
		response.setErrorCode(error.getErrorCode());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ExceptionResponse> globalExceptionHandler(Exception error){
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMsg(error.getMessage());
		response.setErrorCode(HttpStatus.METHOD_NOT_ALLOWED.toString());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.METHOD_NOT_ALLOWED);
	}

}
