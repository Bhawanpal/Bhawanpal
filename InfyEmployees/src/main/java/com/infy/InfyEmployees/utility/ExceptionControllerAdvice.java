package com.infy.InfyEmployees.utility;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.InfyEmployees.exception.InfyEmployeesException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
 
	private static final Log LOGGER = LogFactory.getLog(ExceptionControllerAdvice.class);
	 
	@Autowired
	Environment environment;
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception)
    {
	LOGGER.error(exception.getMessage(), exception);
	ErrorInfo errorInfo = new ErrorInfo();
	errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	errorInfo.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE"));
	errorInfo.setTimeStamp(LocalDateTime.now());
	return new ResponseEntity<>(errorInfo,HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(InfyEmployeesException.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(InfyEmployeesException exception)
    {
	LOGGER.error(exception.getMessage(), exception);
	ErrorInfo errorInfo = new ErrorInfo();
	errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	errorInfo.setErrorMessage(environment.getProperty(exception.getMessage()));
	errorInfo.setTimeStamp(LocalDateTime.now());
	errorInfo.setErrorCode(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<>(errorInfo,HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(MethodArgumentNotValidException exception)
    {
	LOGGER.error(exception.getMessage(), exception);
	ErrorInfo errorInfo = new ErrorInfo();
	errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
	errorInfo.setErrorMessage(environment.getProperty(exception.getMessage()));
	errorInfo.setTimeStamp(LocalDateTime.now());
	
    String errorMsg = exception.getBindingResult()
			    .getAllErrors()
			    .stream()
			    .map(ObjectError::getDefaultMessage)
			    .collect(Collectors.joining(", "));
    errorInfo.setErrorMessage(errorMsg);
    
 return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }
	
}