package com.itheima.dao.impl;

import org.springframework.stereotype.Repository;

import com.itheima.dao.BookDao;

@Repository
public class BookDaoImpl implements BookDao{

	public String findName(int id) {
		System.out.println("id:" + id);
		if(true)throw new NullPointerException();
		return "itcast";
	}
	

}
