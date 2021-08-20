package com.study.spring.case05.proxy.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.logging.Handler;

import org.apache.commons.lang3.ClassUtils.Interfaces;
import org.springframework.asm.Handle;
import org.w3c.dom.ls.LSOutput;

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
			Object result=null;
			try {
			  //前置通知
			  System.out.println("前置Log:"
			                      +object.getClass()+","
					              +method.getName()+","
			                      +Arrays.toString(args));
			  result=method.invoke(object, args); //代理呼叫方法 args=xy值/object代理物件
			  return result;
			} catch (Exception e) {
				//e.printStackTrace(System.out);
				//例外異常通知(只給通知,錯誤還是要手動處理)
				System.out.println("後置Log:"+object.getClass()+","+e);
			}finally {
			  //後置通知(必做)
				 System.out.println("後置Log:"
	                      +object.getClass()+","
			              +method.getName()+","
	                      +result);
			}
			return result;
		};
		
		
		Object proxyObj = Proxy.newProxyInstance(loader, interfaces, handler);
		return proxyObj;
	}
}
