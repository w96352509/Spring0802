package com.study.spring.case04;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.javafaker.Faker;
import com.study.spring.case02.Paper;
import com.study.spring.case03.controller.UserController;
import com.study.spring.case03.model.Page;
import com.study.spring.case03.model.User;

public class PersonTest {

	public static void main(String[] args) {
		Faker faker=new Faker();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext4.xml");
        PersonController pc = ctx.getBean("personController",PersonController.class);
        pc.addPerson(faker.name().firstName(), faker.date().birthday());
        pc.queryPerson();
        System.out.println(pc.queryPerson());
        List<Person> people=pc.queryPerson();
        System.out.println(people);
        System.out.println(people.size());
	}

}
