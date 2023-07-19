package com.itheima;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	 public static void main(String[] args) {
	        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
	        //说明第三方bean对象已经被spring的IOC容器进行管理
	        System.out.println(dataSource);

	    }

}
