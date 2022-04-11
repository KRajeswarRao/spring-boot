package com.abc.ecom.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.abc.ecom.payload.ErrorInfo;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorInfo> handleProductNotExistingException(Exception e,HttpServletRequest req){
		
		String uri = req.getRequestURI().toString();
		ErrorInfo errorInfo = new ErrorInfo(uri,e.getMessage());
		ResponseEntity<ErrorInfo> responseEntity = new ResponseEntity<>(errorInfo,HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> handleException(Exception e,HttpServletRequest req){
		
		String uri = req.getRequestURI().toString();
		ErrorInfo errorInfo = new ErrorInfo(uri,e.getMessage());
		ResponseEntity<ErrorInfo> responseEntity = new ResponseEntity<>(errorInfo,HttpStatus.INTERNAL_SERVER_ERROR);
		return responseEntity;
	}
	
	
}
