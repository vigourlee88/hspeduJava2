package com.hspedu.class_;

//说明一个类加载的连接阶段-准备
public class ClassLoad02 {
	public static void main(String[] args) {
		
	}
}
class A{
	//属性-成员变量-字段
	//分析类加载的连接阶段-准备 属性是如何处理
	//1.n1是实例属性，不是静态变量，因此在准备阶段，是不会分配内存
	//2.n2是静态变量，分配内存 n2是默认初始化 0 而不是20
	//3.n3是static final 是常量，他和静态变量不一样，因为一旦赋值就不变n3 = 30
	public int n1 =10;
	public static int n2 =20;
	public static final int n3 =30;
}