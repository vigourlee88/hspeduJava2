package com.hspedu.reflection.question;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//演示通过反射机制创建实例
public class ReflectCreateInstance {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//1.先获取到User类的Class对象
		Class<?> userClass = Class.forName("com.hspedu.reflection.question.User");
		//2.通过public的无参构造器创建实例
		Object o = userClass.newInstance();
		System.out.println(o);
		//3.通过public的有参构造器创建实例,getConstructor获得共有构造器(传入String.class对象);
		/*
		 * constructor对象就是
		 * 
		 * public User(String name) {
		     this.name = name;
	      }
		 */
		//3.1先得到对应的构造器
		Constructor<?> constructor = userClass.getConstructor(String.class);
		//3.2创建实例，并传入实参
		Object hsp = constructor.newInstance("hsp");
		System.out.println("hsp=" + hsp);
		//4.通过非public的有参构造器创建实例
		//4.1得到private的构造器
		Constructor<?> constructor1= userClass.getDeclaredConstructor(int.class,String.class);
		//4.2创建实例
		//爆破，使用反射可以访问private构造器/方法/属性
		constructor1.setAccessible(true);
		Object user2 = constructor1.newInstance(100,"张三丰");
		System.out.println("user2=" + user2);
	}
}
class User{
	private int age = 0;
	private String name= "hspedu";
	
	public User(){
		
	}
	public User(String name) {//公有构造器
		this.name = name;
	}
	private User(int age,String name) {//私有构造器
		this.age = age;
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + "]";
	}
	
}