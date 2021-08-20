package com.study.spring.case05.proxy.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Handler;

import org.apache.commons.lang3.ClassUtils.Interfaces;
import org.springframework.asm.Handle;

public class ProxyUtil {
	private Object object;

	public ProxyUtil(Object object) {
		this.object = object;
	}

	public Object getProxy() {
		//類別載入器
		ClassLoader loader = getClass().getClassLoader(); 
		//目標所實作的介面
		Class[] interfaces = object.getClass().getInterfaces();
		//處理代理的實現
		InvocationHandler handler = (Object proxy, Method method, Object[] args)->{
			
			return null;
		};
		
		
		Object proxyObj = Proxy.newProxyInstance(loader, interfaces, handler);
		return proxyObj;
	}
}
