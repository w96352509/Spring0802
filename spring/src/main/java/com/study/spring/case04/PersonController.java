package com.study.spring.case04;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
	@Autowired
	private PersonService personService;

	public boolean addPerson(String name , Date birDate) {
		Person person = new Person();
		Calendar now = Calendar.getInstance();
		Calendar bir = Calendar.getInstance();
		now.setTime(new Date());
		bir.setTime(birDate);
		person.setName(name);
		//計算age(today-birth) 取 year
		person.setAge((now.get(Calendar.WEEK_OF_YEAR)-bir.get(Calendar.WEEK_OF_YEAR)));
		person.setBirDate(birDate);
		return personService.append(person);
	}
	public  List<Person> queryPerson() {
		return personService.findAll();
	}
}
