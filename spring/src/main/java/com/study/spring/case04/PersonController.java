package com.study.spring.case04;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
	@Autowired
	private PersonService personService;

	public boolean addPerson(String name , Date birDate) {
		Person person = new Person();
		person.setName(name);
		//計算age(today-birth) 取 year
		person.setBirDate(birDate);
		return personService.append(person);
	}
	public  List<Person> queryPerson() {
		return personService.findAll();
	}
}
