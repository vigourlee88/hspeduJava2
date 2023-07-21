package com.itheima.dao.impl;

import org.springframework.stereotype.Repository;

import com.itheima.dao.BookDao;

@Repository
//1.导入aop相关坐标
//2.定义dao接口与实现类
public class BookDaoImpl implements BookDao{
	
	public void save() {
		System.out.println(System.currentTimeMillis());
        System.out.println("book dao save...");
    }

    public void update(){
        System.out.println("book dao update ...");
    }

}
