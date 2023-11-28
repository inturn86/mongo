package com.mongo.starter.exception.api;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
public class ApiException extends RuntimeException{
	private String errorCode;
}
