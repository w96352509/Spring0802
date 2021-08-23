package com.study.spring.case05.aopxml;

import org.springframework.stereotype.Component;

@Component
public class CalcImpl implements Calc {

	@Override
	public Integer add(Integer x, Integer y) {
		Integer result = x + y;
		return result;
	}

	@Override
	public Integer div(Integer x, Integer y) {
		Integer result = x / y;
		return result;
	}

}
