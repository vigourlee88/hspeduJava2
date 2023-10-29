package com.itheima.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
	public static void main(String[] args) {
		// 定义一个上下文对象,验证Bean初始化是否成功
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
//		Object cat = ctx.getBean("cat");// 参数是String
//		System.out.println(cat);
//		Dog dog = ctx.getBean(Dog.class);// 参数是类名,类型
//		System.out.println(dog);

		String[] names = ctx.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);

		}
	}
}
