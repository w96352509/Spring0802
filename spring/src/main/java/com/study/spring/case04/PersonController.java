  package com.study.spring.case04;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	public boolean addPerson(String name, Date birth) {
		Person person = new Person();
		Date date = new Date();
		//取得目前年月日
		int year= date.getYear();
		int mon=date.getMonth();
		int day=date.getDay();
		//取得生日年月日
		int birth1=birth.getYear();
		int birth2=birth.getMonth();
		int birth3=birth.getDay();
		//age (today - birth)
		int age = year-birth1;
		if (mon<birth2 ||(mon==birth2 && day<birth3)) {
			age--;
		}
		person.setName(name);
		// honework: 請計算 age (today - birth) 取 year
		person.setAge(age);
		person.setBirth(birth);
		return personService.append(person);
	}
	
	public List<Person> queryPerson() {
		return personService.findAll();
	}
	
}