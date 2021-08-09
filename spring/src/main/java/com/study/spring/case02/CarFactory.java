package com.study.spring.case02;

import java.util.Random;

import org.springframework.beans.factory.FactoryBean;

public class CarFactory implements FactoryBean<Car> {

	@Override
	public Car getObject() throws Exception {
		Car car = new Car();
		car.setName("BMW");
		car.setPrice(1500000+new Random().nextInt(1000000));

		return car;
	}

	@Override
	public Class<?> getObjectType() {
		
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		
		return false;
	}

}
