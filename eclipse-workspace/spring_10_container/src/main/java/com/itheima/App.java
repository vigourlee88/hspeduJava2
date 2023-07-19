package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itheima.dao.BookDao;

public class App {
	public static void main(String[] args) {
		//1.加载类路径下的配置文件
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.从文件系统下加载配置文件
//		ApplicationContext ctx = new FileSystemXmlApplicationContext("D:/hspeduJava2/eclipse-workspace/spring_10_container/src/main/resources/applicationContext.xml");
		
		//使用bean的名称获取
//		BookDao bookDao = (BookDao) ctx.getBean("bookDao");
		//使用bean的名称获取并指定类型
//		BookDao bookDao = ctx.getBean("bookDao",BookDao.class);
		//使用bean类型获取，必须要确保IOC容器中该类型对应的bean对象只能有一个。
//		BookDao bookDao = ctx.getBean(BookDao.class);
//		bookDao.save();
	}

}
