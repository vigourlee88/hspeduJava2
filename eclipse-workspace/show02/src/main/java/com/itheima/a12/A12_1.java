package com.itheima.a12;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class A12_1 {
	
	interface Foo{
		void foo();
		void bar();
	}
	
	static class Target implements Foo{
		
		public void foo() {
			System.out.println("target foo");
		}

		@Override
		public void bar() {
		
			System.out.println("target bar");
		}
	}
	
	interface InvocationHandler{
		void invoke(Method method,Object[] args) throws Throwable;
	}
	
    public static void main(String[] args) {
	    Foo proxy = new $Proxy_1(new InvocationHandler() {
	    	@Override
	    	public void invoke(Method method,Object[] args) throws IllegalAccessException, InvocationTargetException {
	    		
	    		//1.功能增强
	    		System.out.println("before...");
	    		//2.调用目标
//	    		new Target().foo();
	    		method.invoke(new Target() , args);
	       }
	    });
	    proxy.foo();
	    proxy.bar();
	}
}
