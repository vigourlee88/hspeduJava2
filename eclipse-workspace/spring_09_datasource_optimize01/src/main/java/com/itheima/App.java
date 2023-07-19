package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mchange.v2.c3p0.ComboPooledDataSource;


//从IOC容器中获取对应的bean对象
public class App {
	 public static void main(String[] args) {
	        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");    
	        ComboPooledDataSource dataSource = ctx.getBean(ComboPooledDataSource.class);
	        System.out.println(dataSource); 
	 }

}
