package com.study.spring.case04;

import java.util.Date;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
public class Person {
	private String name;
	
	private Integer age;
    
	private Date birDate ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirDate() {
		return birDate;
	}

	public void setBirDate(Date birDate) {
		this.birDate = birDate;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(age, birDate, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(age, other.age) && Objects.equals(birDate, other.birDate)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", birDate=" + birDate + "]";
	}
	
	
}
