package com.itheima.dao.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.itheima.dao.BookDao;

@Repository("bookDao")
public class BookDaoImpl implements BookDao{
	
	//@Value("itheima")
	@Value("${name}")
	private String name;
	
	public void save() {
		System.out.println("book dao save..." + name);
		
	}
}
