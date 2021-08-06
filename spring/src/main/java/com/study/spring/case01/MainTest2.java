package com.study.spring.case01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
  public class Husband{
   private String name;
   Private Wife wife;
  }
  
   public class Wife{
   private String name;
   Private Husband husband;
   //..
  }
  John->Mary
  Mary->John
 */

public class MainTest2 {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Husband husband = (Husband) ctx.getBean("husband");
		Wife wife = (Wife) ctx.getBean("wife");
		System.out.println(wife);
	    System.out.println(husband);
		System.out.printf("%s 的老公是 %s\n",husband.getName(),husband.getWife().getName());
		System.out.printf("%s 的老婆是 %s\n",wife.getName(),wife.getHusband().getName());
	}

}
