package com.bridgelabz.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bridgelabz.userservice.response.Response;

@RestControllerAdvice
public class GlobalExceptionHandler
{
	@ExceptionHandler(UserException.class)
	public ResponseEntity<Response> handleUserException(UserException exc)
	{
		Response error=new Response();
		
		error.setMessage(exc.getMessage()); 
		error.setStatus(exc.errorCode); 
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error,HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> handleException(Exception exc)
	{
		Response error=new Response();
		
		error.setMessage(exc.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());	
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
