package com.study.spring.case05.aop_dancer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("AOPConfig.java");
		Performance performance = (Performance)ctx.getBean("dancer");
		performance.perform();

	}

}
