package com.study.spring.case02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTestHomeWork {

	public static void main(String[] args) {
		ApplicationContext ctx  = new ClassPathXmlApplicationContext("beans-config.xml");
	    Round r1 =(Round)ctx.getBean("r");
	    System.out.println(r1);
	    System.out.println(r1.getRoundArea());
		
		
	}

}