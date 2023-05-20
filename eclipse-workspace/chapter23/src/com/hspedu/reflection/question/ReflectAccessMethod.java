package com.hspedu.reflection.question;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//演示通过反射调用方法
public class ReflectAccessMethod {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
		//1.得到Boss类对应的Class对象
		Class<?> bossCls = Class.forName("com.hspedu.reflection.question.Boss");
		//2.创建对象
		Object o = bossCls.newInstance();
		//3.调用public普通方法
		//Method hi = bossCls.getMethod("hi",String.class);//ok
		//3.1得到hi方法对象
		Method hi = bossCls.getDeclaredMethod("hi",String.class);//ok
		//3.2调用
		hi.invoke(o, "韩顺平");
		
		//4.调用private static 方法
		//4.1得到say方法对象
		Method say = bossCls.getDeclaredMethod("say", int.class,String.class,char.class);
		//4.2因为say方法是私有的，需要爆破，原理跟构造器和属性一样
		say.setAccessible(true);
		System.out.println(say.invoke(o, 100,"张三",'男'));
		//say是静态方法，还可以这样调用，传入null
		System.out.println(say.invoke(null, 100,"李四",'女'));
		
		//5.在反射中，如果方法有返回值，统一返回Object，但是它的运行类型和方法定义的返回类型一致
		Object reVal = say.invoke(null,300,"王五",'男');
		System.out.println("reVal的运行类型=" + reVal.getClass());//String
		
	}
}
class Boss{
	public int age;
	private static String name;
	
	public Boss() {
		
	}
	//私有的静态方法
	private static String say(int n,String s,char c) {
		return n + " " + s + " " + c;
	}
	
	public void hi(String s) {
		System.out.println("hi " + s);
		
	}
}