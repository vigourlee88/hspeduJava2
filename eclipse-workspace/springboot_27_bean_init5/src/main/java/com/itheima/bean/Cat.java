package com.itheima.bean;

import org.springframework.stereotype.Component;

@Component("tom") // 相当于<bean id class/>
public class Cat {
	public Cat() {

	}

	int age;

	public Cat(int age) {
		this.age = age;

	}

	@Override
	public String toString() {
		return "Cat [age=" + age + "]";
	}

}
