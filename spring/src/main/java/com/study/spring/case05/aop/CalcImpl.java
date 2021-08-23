package com.study.spring.case05.aop;

import org.springframework.stereotype.Component;

@Component
public class CalcImpl implements Calc {

	@Override
	public int add(int x, int y) {
		int result = x + y;
		return result;
	}

	@Override
	public int div(int x, int y) {
        int result = x / y;
		return result;
	}

}
