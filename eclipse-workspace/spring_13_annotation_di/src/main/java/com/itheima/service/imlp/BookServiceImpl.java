package com.itheima.service.imlp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	//注解开启自动装配模式，指定加载bean名称
	//相同类型的bean需要使用@Qualifier
	//自动装配模式基于反射设计创建对象
	//注意:
	//并暴力反射对应属性为私有属性初始化数据,因此无需提供setter方法
	//建议使用无参构造方法创建对象(默认)，如果不提供对应构造方法，请提供唯一的构造方法
	@Autowired
	@Qualifier("bookDao")
	private BookDao bookDao;
	
//	public void setBookDao(BookDao bookDao) {
//		this.bookDao = bookDao;
//	}

	public void save() {
		System.out.println("book service save...");
		bookDao.save();
	}

}
