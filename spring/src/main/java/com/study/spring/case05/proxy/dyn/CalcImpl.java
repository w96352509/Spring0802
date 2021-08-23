package com.study.spring.case05.proxy.dyn;

public class CalcImpl implements Calc{

	@Override
	public int add(int x, int y) {
		int result= x+y;
		return result;
	}

	@Override
	public int div(int x, int y) {
		int result= x/y;
		return result;
	}
	
	private Long getMoney() {
		
		return 270_000_000L;
	}
	
}
