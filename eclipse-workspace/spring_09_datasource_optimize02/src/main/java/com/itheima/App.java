package com.itheima;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.dao.BookDao;

//从IOC容器中获取bookDao对象，调用方法，查看值是否已经被获取到并打印控制台
public class App {
	 public static void main(String[] args) {
			
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
//      DataSource dataSource = (DataSource) ctx.getBean("dataSource");
//      System.out.println(dataSource);
		 
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();
	 }

}
