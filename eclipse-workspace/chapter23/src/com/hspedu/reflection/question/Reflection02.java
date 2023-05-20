package com.hspedu.reflection.question;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.hspedu.Cat;

//测试反射调用的性能，和优化方案
@SuppressWarnings({"all"})
public class Reflection02 {
	public static void main(String[] args) throws InvocationTargetException, Exception {
		
		m1();
		m2();
		m3();
	}
	//传统方法来调用hi
	public static void m1() {
		Cat cat = new Cat();
		long start = System.currentTimeMillis();
		for(int i = 0;i < 90000000;i++) {
			cat.hi();
		}
		long end = System.currentTimeMillis();
		System.out.println("m1()来调用hi 耗时=" + (end -start));
	}
	
	//反射机制调用方法 hi()
	public static void m2() throws Exception, InvocationTargetException {
		Class cls = Class.forName("com.hspedu.Cat");
		Object o = cls.newInstance();
		Method hi = cls.getMethod("hi");
		long start = System.currentTimeMillis();
		for(int i = 0;i < 90000000;i++) {
			hi.invoke(o);//反射机制调用 Method对象来调用o
		}
		long end = System.currentTimeMillis();
		System.out.println("m2()来调用hi 耗时=" + (end -start));
	}
	
	//反射调用优化 + 关闭访问检查
	public static void m3() throws Exception, InvocationTargetException {
		Class cls = Class.forName("com.hspedu.Cat");
		Object o = cls.newInstance();
		Method hi = cls.getMethod("hi");
		hi.setAccessible(true);//在反射调用方法时，取消访问检查
		long start = System.currentTimeMillis();
		for(int i = 0;i < 90000000;i++) {
			hi.invoke(o);//反射机制调用 Method对象来调用o
		}
		long end = System.currentTimeMillis();
		System.out.println("m3()来调用hi 耗时=" + (end -start));
	}
}
