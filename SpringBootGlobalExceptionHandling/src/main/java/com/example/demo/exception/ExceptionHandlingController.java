package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.ExceptionResponse;

@ControllerAdvice
public class ExceptionHandlingController {
	
	@ExceptionHandler
	public @ResponseBody ExceptionResponse handlingException(AccountNotFound accountNotFound,HttpServletRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setUri(request.getRequestURI());
		exceptionResponse.setErrormsg(accountNotFound.getMessage());
		
		return exceptionResponse;
	}

	
}
