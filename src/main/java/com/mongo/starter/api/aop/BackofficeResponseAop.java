package com.mongo.starter.api.aop;


import com.mongo.starter.exception.api.ApiException;
import com.mongo.starter.exception.noauth.NoAuthException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.naming.AuthenticationException;

@Component
@Aspect
@Slf4j
public class BackofficeResponseAop {

	@Around("execution(* com.mongo.starter.controller..*.*(..))")
	public Object backofficeReponseAspect(ProceedingJoinPoint proceed)  {

		long startSecond = System.currentTimeMillis();
		log.error("Api Processing Start {} ", startSecond);
		Object result = null;

		try {
			result = proceed.proceed();
		} catch (Throwable e) {
			throw new RuntimeException();
		}
		final long endSecond = System.currentTimeMillis();
		log.error("Api Processing End {} ", endSecond);
		log.error("Api Processing millsecond {} ", endSecond - startSecond);
		return result;

	}
}
