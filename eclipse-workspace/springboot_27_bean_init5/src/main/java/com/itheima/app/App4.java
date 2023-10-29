package com.itheima.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.itheima.bean.Dog;
import com.itheima.config.SpringConfig4;

public class App4 {
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig4.class);
		String[] names = ctx.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);// com.itheima.bean.Dog
		}
		System.out.println("----------------");
		System.out.println(ctx.getBean(Dog.class));
	}
}
