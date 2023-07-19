package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.dao.UserDao;
import com.itheima.service.BookService;


public class BookServiceImpl implements BookService{

	private BookDao bookDao;
	private UserDao userDao;
	
   //通过构造器传入参数
    public BookServiceImpl(BookDao bookDao,UserDao userDao) {
		super();
		this.bookDao = bookDao;
		this.userDao = userDao;
	}

	public void save() {
        System.out.println("book service save ...");
        bookDao.save();
        userDao.save();
    }

}
