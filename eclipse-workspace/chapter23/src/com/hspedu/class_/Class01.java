package com.hspedu.class_;

import com.hspedu.Cat;

//对Class类特点的梳理
@SuppressWarnings({"all"})
public class Class01 {
	public static void main(String[] args) throws ClassNotFoundException {
		
		//1.Class也是类，因此也继承Object类
		//2.Class类对象不是new出来的，而是系统创建的
		//(1)传统new对象
		/* ClassLoader类
		 * public Class<?> loadClass(String name) throws ClassNotFoundException{
		 *  return laodClass(name,false);
		 * }
		 */
//		Cat cat = new Cat();//同一个类，只会加载一次
	
		//(2)反射方式
		//没有debug到ClassLoader类的loadClass,原因是
		//没有注销Cat cat = new Cat();
		/* 
		 * ClassLoader类，仍然通过ClassLoader类加载Cat类的Class对象
		 * public Class<?> loadClass(String name) throws ClassNotFoundException{
		 *  return laodClass(name,false);
		 * }
		 */
		Class cls1 = Class.forName("com.hspedu.Cat");

		//3.对于某个类的Class类对象，在内存中只有一份，因为类只加载一次
		Class cls2 = Class.forName("com.hspedu.Cat");
		System.out.println(cls1.hashCode());
		System.out.println(cls2.hashCode());
		Class cls3 = Class.forName("com.hspedu.Dog");
		System.out.println(cls3.hashCode());
	}
}
