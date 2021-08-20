package com.study.spring.case05.proxy.sta;

interface Person {
	void work();
}

class Man implements Person {
	@Override
	public void work() {

		System.out.println("上班工作");

	}

}

class Woman implements Person {

	@Override
	public void work() {

		System.out.println("去市場買菜");

	}

}

//靜態代理
class PersonProxy implements Person {
	private Person person;

	public PersonProxy(Person person) {
		this.person = person;
	}

	@Override
	public void work() {
		//執行前公用方法
		System.out.println("戴口罩");
		//代理調用-業務方法
		try {
			person.work();
		} catch (Exception e) {
		//例外公用方法
			System.out.println("買口罩");
		}
		//執行後公用方法
		System.out.println("脫口罩");
	}

}

public class ProxyDemo {
	public static void main(String[] args) {
		// 不透過代理 , 直接執行
		/*Person p1 = new Man();
		Person p2 = new Woman();
		p1.work();
		p2.work();*/
		Person p1 = new PersonProxy(new Man());
		Person p2 = new PersonProxy(new Woman());
		p1.work();
		p2.work();

	}

}
