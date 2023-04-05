package com.zkteco.moviehub.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.zkteco.moviehub.dto.MyErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<MyErrorDetails> movieNotFoundExceptionHandler(MovieNotFoundException mnf, WebRequest req){
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),mnf.getMessage(),req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception e, WebRequest req){
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),e.getMessage(),req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.NOT_FOUND);
	}
	
}
