package com.itheima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.dao.BookDao;

public class AppForLifeCycle {
	 public static void main( String[] args ) {
       
	   ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	    //ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml"); 
        
	    BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();
        
        //注册关闭钩子函数，在虚拟机退出之前回调此函数，关闭容器
        //在容器未关闭之前，提前设置好回调函数，让JVM在退出之前回调此函数来关闭容器
        //registerShutdownHook在ApplicationContext中也没有,ClassPathXmlApplicationContext有
        ctx.registerShutdownHook();
      
        //关闭容器
        //ctx.close();
    }

}
