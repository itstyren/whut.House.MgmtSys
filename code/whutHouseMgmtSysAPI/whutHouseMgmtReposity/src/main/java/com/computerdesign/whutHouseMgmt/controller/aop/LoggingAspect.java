package com.computerdesign.whutHouseMgmt.controller.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
public class LoggingAspect {

	@Before("execution(* com.computerdesign.whutHouseMgmt.controller..*.*(..))")
	public void before(JoinPoint joinPoint){
		System.out.println("aaa");
	}
	
	@After("execution(* com.computerdesign.whutHouseMgmt.controller..*.*(..))")
	public void after(JoinPoint joinPoint){
		System.out.println("aaa");
	}
	
}
