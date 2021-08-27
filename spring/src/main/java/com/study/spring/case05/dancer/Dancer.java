package com.study.spring.case05.dancer;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class Dancer implements Performance {

	@Override
	public void perform() {
		System.out.println("表演開始 , POPPING");
		if (new Date().getTime() % 3 == 0) {
        throw new RuntimeException("舞者起飛了");
		}
	}

}
