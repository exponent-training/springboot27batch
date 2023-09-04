package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.ErrorResponse;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler
	@ResponseBody
	public ErrorResponse handleException(EmployeeNotFound exception,HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrormsg(exception.getMessage());
		errorResponse.setUri(request.getRequestURI());
		return errorResponse;
	}
	
}
