package com.study.spring.case05.dancer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class Audience {
	@Pointcut(value = "execution(* package com.study.spring.case05.dancer.Dancer.*(..))")
	public void pt() {

	}

	@Around(value = "pt()")
	public Object around(ProceedingJoinPoint joinPoint) {
		Object result=null;
		try {
        System.out.println("關掉手機");
        System.out.println("找到座位");
        result=joinPoint.proceed();
        System.out.println("拍手鼓掌");	
		} catch (Throwable e) {
			System.out.println("退票！退票！");
		} finally {
			System.out.println("離開表演場");
		}
     return result;
	}

}
