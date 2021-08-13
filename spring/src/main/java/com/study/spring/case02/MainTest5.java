package com.study.spring.case02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest5 {

	public static void main(String[] args) {
		ApplicationContext ctx  = new ClassPathXmlApplicationContext("applicationContext2.xml");
	    Paper p1 = (Paper)ctx.getBean("paper") ;
	    System.out.println(p1);
		
		
	}

}