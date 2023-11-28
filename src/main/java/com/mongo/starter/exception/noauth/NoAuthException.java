package com.mongo.starter.exception.noauth;


import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class NoAuthException extends RuntimeException{

	private String errorCode;
}
