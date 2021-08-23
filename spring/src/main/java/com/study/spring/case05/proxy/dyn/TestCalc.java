package com.study.spring.case05.proxy.dyn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalTime;
import java.util.Iterator;

import com.github.javafaker.File;
import com.study.spring.case05.proxy.sta.Man;
import com.study.spring.case05.proxy.sta.Person;
import com.study.spring.case05.proxy.sta.PersonProxy;

public class TestCalc {

	private Object object;

	public static void main(String[] args) throws Exception {
		Calc calc = (Calc) new ProxyUtil(new CalcImpl()).getProxy();
		
		System.out.println(calc.add(10, 20));
		System.out.println();
		System.out.println(calc.div(10, 10));
      
		Class<?> class1 = Long.class;
        class1 = Class.forName("com.study.spring.case05.proxy.dyn.CalcImpl");//獲取路徑
        Calc calc3= (Calc)class1.newInstance();          // 取得實利
        Method method = class1.getDeclaredMethod("getMoney");//尋找方法
        method.setAccessible(true);                          //防止EX
        method.invoke(calc3);//方法
        System.out.println(method);
        
        
        
        
		
		

		
		
		
	
	}

}
