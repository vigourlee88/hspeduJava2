package com.hspedu.reflection.question;

import java.lang.reflect.Field;

//演示反射操作属性
public class ReflectAccessProperty {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		//1.得到Student类对应的Class类
		Class<?> stuClass = Class.forName("com.hspedu.reflection.question.Student");
		//2.创建对象  //无参构造器创建对象
		Object o = stuClass.newInstance();//o 的运行类型就是Student
		System.out.println(o.getClass());//Student
		//3.我们反射得到age 属性对象
		Field age = stuClass.getField("age");
		age.set(o, 88);//通过反射来操作属性
		System.out.println(o);//88
		System.out.println(age.get(o));//88
		
		//4.使用反射操作我们的name 属性
		Field name = stuClass.getDeclaredField("name");
		//对name进行爆破,可以操作private 属性
		name.setAccessible(true);
		//name.set(o,"老韩");
		name.set(null, "老韩");//因为name是静态的，因此也可以写成null
		System.out.println(o);
		System.out.println(name.get(o));//获取属性值
		System.out.println(name.get(null));//获取属性值，要求name是静态的
		
		
	}
}
class Student {//类
	public int age;
	private static String name;
	
	public Student() {//构造器
		
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ",name=" + name + "]";
	}

}