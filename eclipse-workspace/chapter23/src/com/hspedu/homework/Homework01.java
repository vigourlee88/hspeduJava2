package com.hspedu.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework01 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, InvocationTargetException {
		 /**
         * 定义PrivateTest类，有私有name属性，并且属性值为hellokitty
         * 提供getName的公有方法
         * 创建PrivateTest的类，利用Class类得到私有的name属性，修改私有的name属性值，并调用getName()的方法打印name属性值
         */
		//1.得到PrivateTest类对应的Class对象
		//Class<?> forName = Class.forName("com.hspedu.homework.PrivateTest");
		Class<PrivateTest> privateTestClass = PrivateTest.class;
		//2.创建对象
		PrivateTest privateTestObj = privateTestClass.newInstance();
		//3.得到name属性对象
		Field name = privateTestClass.getDeclaredField("name");//name属性是private
		//4.爆破 私有属性
		name.setAccessible(true);
		name.set(privateTestObj,"天龙八部");//用反射创建的对象
		//5.得到getName方法对象
		Method getName = privateTestClass.getMethod("getName");
		//6.因为getName()是public 所以直接调用
		Object invoke = getName.invoke(privateTestObj);
		System.out.println("name属性值=" + invoke);
	}

}
class PrivateTest{
	private String name = "hellokitty";
	
	//默认无参构造器
	
	public String getName() {
		return name;
	}
}