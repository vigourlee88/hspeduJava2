package com.hspedu.reflection.question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

@SuppressWarnings({"all"})
public class Reflection01 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException, NoSuchFieldException {
		//1.使用Properties类，可以读写配置文件
		Properties properties = new Properties();
		properties.load(new FileInputStream("src\\re.properties"));//加载文件
		String classfullpath = properties.get("classfullpath").toString();//读取文件
		String methodName = properties.get("method").toString();
		
		
		//2.使用发射机制解决
		//(1)加载类,返回Class类型的对象
		Class cls = Class.forName(classfullpath);
		//(2)通过cls得到你加载的类com.hapedu.Cat的对象实例
		Object o = cls.newInstance();
		System.out.println("o的运行类型=" + o.getClass());//得到运行类型
		//(3)通过cls得到你加载的类com.hspedu.Cat的methodName "hi"的方法对象
		//即:在反射中，可以把方法视为 对象
		Method method1 = cls.getMethod(methodName);
		//(4)通过method1调用方法 即通过方法对象来实现调用方法
		System.out.println("===============");
		method1.invoke(o);//传统方法 对象.方法() 反射机制 方法.invoke(对象)
		
		//java.lang.reflect.Field:代表类的成员变量，Field对象表示某个类的成员变量
		//得到name字段
		//getField不能得到私有的属性
		Field nameField = cls.getField("age");
		//传统方法 对象.成员变量 反射: 成员变量对象.get(对象)
		System.out.println(nameField.get(o));
	
		//java.lang.reflect.Contructor: 代表类的构造方法，Contructor对象表示构造器
	    Constructor constructor = cls.getConstructor();//()中可以指定构造器参数类型，返回无参构造器
	    System.out.println(constructor);//Cat()
	
	    //这里老师传入的String.class 就是String类的Class对象
	    Constructor constructor2 = cls.getConstructor(String.class);
	    System.out.println(constructor2);//Cat(String name)
	    
	}	
	
}
