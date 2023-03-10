package com.divergentsl.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
 
    @ExceptionHandler(NameNotFoundException.class)
    public ResponseEntity<String> handleUserDefineException(NameNotFoundException nameNotFoundException)
    {
    	return new ResponseEntity<String>("Name Not Found Exception Came",HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handlePredefineException(ArithmeticException arithmeticException)
    {     
    	System.out.println("hi");
    	log.info("hello",arithmeticException);
    	System.out.println("hello");
    	return new ResponseEntity<String>("Arithmetic Exception Came",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
    		HttpHeaders headers, HttpStatus status, WebRequest request) {
//    	return new ResponseEntity<Object>(ex.getMessage(),status);
    	return new ResponseEntity<Object>("Hello",HttpStatus.OK);
    }
     
   
}