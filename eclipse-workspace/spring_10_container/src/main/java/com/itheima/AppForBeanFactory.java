package com.itheima;

import java.awt.DefaultKeyboardFocusManager;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.itheima.dao.BookDao;

public class AppForBeanFactory {
	public static void main(String[] args) {
		//1.ApplicationContext 立即加载Bean,启动容器直接初始化
		//获取到配置文件，初始化出来beanFactory对象
		Resource resources = new ClassPathResource("applicationContext.xml");
		//2.BeanFactory 延迟加载bean
		BeanFactory bf= new XmlBeanFactory(resources);
//		BookDao bookDao = bf.getBean(BookDao.class);
//		bookDao.save();
	}

}
