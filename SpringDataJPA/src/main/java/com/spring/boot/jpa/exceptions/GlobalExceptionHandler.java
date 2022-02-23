package com.spring.boot.jpa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.boot.jpa.exceptions.dto.BadRequestExceptionDto;

@ControllerAdvice
public class GlobalExceptionHandler 
{
    
	 @ExceptionHandler(BadRequestException.class)
	 public ResponseEntity<BadRequestExceptionDto> handleBadRequest(BadRequestException badRequestException)
	 {
		  BadRequestExceptionDto badRequestExceptionDto = new BadRequestExceptionDto(badRequestException.getMessage(),2);
		  return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(badRequestExceptionDto);
	 }
}
