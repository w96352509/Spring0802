package com.study.spring.case05.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect // 切面
@Order(1) // 數字越小越先被執行(預設 order 的數值是 int 的最大值)
public class MyLoggerAspect {
	// Pointcut 切入點是用來定義 JoinPoint 連接點
	@Pointcut(value = "execution(* com.study.spring.case05.aop.CalcImpl.*(..))")
	public void pt() {
	}

	@Pointcut(value = "execution(* com.study.spring.case05.aop.CalcImpl.div(..))")
	public void pt2() {
	}

	// 前置通知
	// @Before(value = "execution(public Integer
	// com.study.spring.case05.aop.CalcImpl.add(Integer, Integer))") // 切入點表達式
	// @Before(value = "execution(public Integer
	// com.study.spring.case05.aop.CalcImpl.*(..))") // 切入點表達式
	// @Before(value = "execution(* com.study.spring.case05.aop.CalcImpl.*(..))") //
	// 切入點表達式
	// @Before(value = "execution(* com.study.spring.case05.aop.*.*(..))") // 切入點表達式
	// @Before(value = "execution(* *.*(..))") // 切入點表達式
	// @Before(value = "pt() &&!pt2()")
	/*
	@Before(value = "pt()")
	public void before(JoinPoint joinPoint) {
		System.out.println("前置通知 - ");
		String methodName = joinPoint.getSignature().getName(); // 獲取方法
		Object[] args = joinPoint.getArgs(); // 獲取方法參數
		System.out.printf("方法名稱：%s，方法參數：%s\n", methodName, Arrays.toString(args));
	}
	
	//後置通知 (會放在Finally 區段中   , 無所以無論是否拋出例外都會執行)
	@After(value = "pt()")
	public void after() {
	  System.out.println("後置通知-");
	  
	}
	
	//接受方法的返回值
	//返回通知(可以設定returning 來接受方法的返回值  (丟入) )
	@AfterReturning(value = "pt()" , returning = "rusult")
	public void afterReturning(Object rusult) {   //名稱對應(丟入)
		System.out.println("返回值"+rusult);
	}
	//異常通知(可以設定 throwing 異常通知變數)    (丟入)
	@AfterThrowing(value = "pt()" , throwing = "ex")
	public void afterThrowing(Exception ex) {   //名稱對應(丟入)
		System.out.println("異常通知"+ex);
	}
	*/
	
	//環繞通知(可以修改值)
	@Around(value = "pt()")
	public Object around(ProceedingJoinPoint joinPoint) {
		Object result=null;
		try {
			//1.前置通知
			System.out.println("環繞通知-前置通知");
			result=joinPoint.proceed();//執行業務邏輯(通常在1的位置也可2(但會同時有異常跟返回))
			//2.返回通知
			System.out.println("環繞通知-返回通知");
		} catch (Throwable e) {
			//3.異常通知
			System.out.println("環繞通知-異常通知:"+e);
		}finally {
			//4.後置通知
			System.out.println("環繞通知-後置通知");
		}
		return result ;
		
	}
}
