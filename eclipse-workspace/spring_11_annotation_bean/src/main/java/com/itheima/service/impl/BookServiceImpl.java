package com.itheima.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;

//@Component,代替业务层
@Service
public class BookServiceImpl implements BookService{
   
	private BookDao bookDao;
	    
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	public void save() {
	     System.out.println("book service save ...");
	     bookDao.save();
	}

}
