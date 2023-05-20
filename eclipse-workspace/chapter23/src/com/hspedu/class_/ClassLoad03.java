package com.hspedu.class_;

//演示类加载-初始化阶段
public class ClassLoad03 {
	public static void main(String[] args) throws ClassNotFoundException {
		//分析
		//1.加载B类，并生成B的class对象
		//2.连接 num = 0;
		//3.初始化阶段
		// 依次自动收集类中的所有的静态变量的赋值动作
		// 和静态代码块中的语句并 合并
		/*
		 * clinit(){//收集
		 *   System.out.println("B 静态代码块被执行");
		 *   //num = 300;
		 *   num = 100;//再执行
		 * }
		 * 合并:num = 100;
		 */
		//4."B() 构造器被执行"
		//new B();//类加载
		//如果直接使用类的静态变量，也会导致类的加载
		//System.out.println(B.num);//B 静态代码块被执行 100
		
		//看看加载类的时候，是有同步机制控制
		/*正因为有这个机制，才能保证某个类在内存中只有一份Class对象
		 *    protected Class<?> loadClassOrNull(String cn, boolean resolve) {
            synchronized (getClassLoadingLock(cn)) {
		 */
		Class<?> b = Class.forName("B");
	}
}
class B {
	static {
		System.out.println("B 静态代码块被执行");
		num =300;
	}
	
	static int num = 100;
	
	public B() {
		System.out.println("B() 构造器被执行");
	}
	
}