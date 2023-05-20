package com.hspedu.class_;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassLoad_ {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入key");
		String key = scanner.next();
		switch(key) {
			case "1":
				Dog dog = new Dog();//编译时加载这个类，静态加载，依赖性很强，编译时就要加载进去
				dog.cry();
				break;
			case "2":
				//反射=>动态加载 真正运行的时候，执行到这块代码的时候加载这个类
				Class cls = Class.forName("Person");//加载Person类
			    Object o = cls.newInstance();
			    Method m = cls.getMethod("hi");
			    m.invoke(o);
				System.out.println("ok");
				break;
			default:
				System.out.println("do nothing");
		}
	}
}
//因为new Dog()是静态加载，因此必须编写Dog
//Person类是动态加载，所以，没有编写Person类也不会报错，只有当动态加载该类时，才会报错
class Dog{
	public void cry() {
		System.out.println("小狗汪汪叫");
	}
}
class Person{
	public void hi() {
		System.out.println("");
	}
}