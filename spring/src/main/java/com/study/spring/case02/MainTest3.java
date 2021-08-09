package com.study.spring.case02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest3 {

	public static void main(String[] args) {
		ApplicationContext ctx  = new ClassPathXmlApplicationContext("applicationContext2.xml");
		Teacher teacher =(Teacher)ctx.getBean("teacher");
		System.out.println(teacher.getTotalCredits());
		System.out.println(teacher.getStudents().size());
		
		
	}

}