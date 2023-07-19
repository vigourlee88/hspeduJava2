package com.itheima.dao.impl;

import org.springframework.stereotype.Repository;

import com.itheima.dao.BookDao;

@Repository("bookDao2")
public class BookDaoImpl2 implements BookDao{
	
	public void save() {
		System.out.println("book dao save...2");
	}
}
