package com.hspedu.reflection.question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import com.hspedu.Cat;

//反射问题的引入
@SuppressWarnings({"all"})
public class ReflectionQuestion {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
		//根据配置文件re.properties 指定信息，创建Cat对象并调用方法 hi()
		
		//传统的方法 new对象=>调用方法
//		Cat cat = new Cat();
//		cat.hi();==>cat.cry() 修改源码
		
		//1.使用Properties类，可以读写配置文件
		Properties properties = new Properties();
		properties.load(new FileInputStream("src\\re.properties"));//加载文件
		String classfullpath = properties.get("classfullpath").toString();//读取文件
		String methodName = properties.get("method").toString();
		System.out.println("classfullpath=" + classfullpath);
		System.out.println("method=" + methodName);
		
		//2.创建对象 传统的方法行不通
		//在学习框架的时候特别多，即通过外部文件配置，
		//在不修改源码情况下，来控制程序，也符合设计模式的OCP(开闭)原则
		//new classfullpath();
		
		//3.使用发射机制解决
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
	}
}
