package com.cg.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerException {

	@ExceptionHandler({UserCreatedException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage badrequest(Exception e)
	{
		return new ErrorMessage(e.getMessage());
	}
}
