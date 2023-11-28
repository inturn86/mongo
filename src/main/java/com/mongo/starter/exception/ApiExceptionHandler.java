package com.mongo.starter.exception;

import com.mongo.starter.api.backoffice.response.DefaultResponse;
import com.mongo.starter.exception.api.ApiException;
import com.mongo.starter.exception.noauth.NoAuthException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.sasl.AuthenticationException;

@RestControllerAdvice(basePackages = "com.mongo.starter.controller.mdm")
public class ApiExceptionHandler {

	//Exception에 따른 분기.
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> exceptionHandler(Exception e) {
		return ResponseEntity.unprocessableEntity().body(getExceptionResponse("ERR-0001", "Occur Exception"));
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Object> badExceptionHandler(HttpMessageNotReadableException e) {
		return ResponseEntity.unprocessableEntity().body(getExceptionResponse("ERR-0002", "Bad Request"));
	}

	@ExceptionHandler(NoAuthException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public Object notAuthExceptionHandler(NoAuthException e) {
		return getExceptionResponse("ERR-0003", "No Auth");
	}

	private DefaultResponse getExceptionResponse(String code, String message) {
		return DefaultResponse.builder().code(code).message(message).build();
	}
}