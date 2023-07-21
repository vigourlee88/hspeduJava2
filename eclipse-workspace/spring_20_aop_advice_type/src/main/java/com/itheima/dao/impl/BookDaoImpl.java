package com.itheima.dao.impl;

import org.springframework.stereotype.Repository;

import com.itheima.dao.BookDao;

@Repository
public class BookDaoImpl implements BookDao{
	
	public int select() {
        System.out.println("book dao select is running...");
//        int i = 1/0;
        return 100;
    }

    public void update(){
        System.out.println("book dao update is running...");
    }

}
