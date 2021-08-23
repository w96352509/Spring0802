package com.study.spring.case05.aopxml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MyLoggerXMLAspect {
 
	public void before(JoinPoint joinPoint) {
	 System.out.println("AOP XML版-前置通知");
	 String methodname = joinPoint.getSignature().getName();
	 Object[] args=joinPoint.getArgs();
	 System.out.printf("方法名稱:%s , 方法參數%s \n", methodname , Arrays.toString(args));
 }

}
