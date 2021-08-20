package com.study.spring.case05.proxy.dyn;

import com.study.spring.case05.proxy.sta.Man;
import com.study.spring.case05.proxy.sta.Person;
import com.study.spring.case05.proxy.sta.Woman;

public class TestPerson {

	public static void main(String[] args) {
		Person p1 = (Person) new ProxyUtil(new Man()).getProxy();
		Person p2 = (Person) new ProxyUtil(new Woman()).getProxy();
		
		p1.work();
		p2.work();


	}

}
