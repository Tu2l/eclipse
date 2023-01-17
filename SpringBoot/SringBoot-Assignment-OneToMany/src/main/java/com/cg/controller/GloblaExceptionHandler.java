package com.cg.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cg.exception.ErrorResponse;
import com.cg.exception.NoSuchCourseFoundException;
import com.cg.exception.NoSuchStudentFoundException;

@ControllerAdvice
@RequestMapping("/")
public class GloblaExceptionHandler {

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	@ExceptionHandler(value = { NoSuchCourseFoundException.class, NoSuchStudentFoundException.class })
	public ErrorResponse handleNotFound(Exception ex, HttpServletRequest req) {
		return new ErrorResponse(ex.getMessage(), req.getRequestURI(), LocalDateTime.now().toString());
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	@ExceptionHandler(value = { Exception.class })
	public ErrorResponse handleError(Exception ex, HttpServletRequest req) {
		return new ErrorResponse(ex.getMessage(), req.getRequestURI(), LocalDateTime.now().toString());
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	public ErrorResponse handleValidationError(MethodArgumentNotValidException ex, HttpServletRequest req) {
		String msg = "validation faild";
		FieldError error = ex.getFieldError();
		if(error != null)
			msg = error.getDefaultMessage();
		
		return new ErrorResponse(msg, req.getRequestURI(),
				LocalDateTime.now().toString());
	}

}
