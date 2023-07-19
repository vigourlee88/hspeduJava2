package com.itheima.dao.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.itheima.dao.BookDao;

@Repository
@Scope("singleton")
public class BookDaoImpl implements BookDao{
	
	public void save() {
		System.out.println("book dao save...");
	}
	
	//构造方法后运行的方法
	@PostConstruct
	public void init() {
		System.out.println("init...");
	}
	
	//彻底销毁前运行的方法
	@PreDestroy
	public void destory() {
		System.out.println("destory...");
	}

}
