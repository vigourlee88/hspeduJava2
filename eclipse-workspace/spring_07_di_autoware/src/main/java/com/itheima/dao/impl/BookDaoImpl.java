package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

public class BookDaoImpl implements BookDao{
	
	private String dataBaseNameString;
	private int connectionNum;
	
	public void save() {
		System.out.println("book dao save ...");
	}
	

}
