package com.study.spring.case05.proxy.dyn;

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
		ClassLoader loader = getClass().getClassLoader(); //類別載入器
		
		Object proxyObj = Proxy.newProxyInstance(loader, Interfaces, Handler);
		return proxyObj;
	}
}
