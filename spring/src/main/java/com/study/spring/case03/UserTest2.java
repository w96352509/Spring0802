package com.study.spring.case03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.case02.Paper;
import com.study.spring.case03.controller.UserController;
import com.study.spring.case03.model.Page;
import com.study.spring.case03.model.User;

public class UserTest2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext3.xml");
        User user = ctx.getBean("user",User.class);
        
        Page page = ctx.getBean("page",Page.class);
        System.out.println(user);
        System.out.println(page);
	}

}
