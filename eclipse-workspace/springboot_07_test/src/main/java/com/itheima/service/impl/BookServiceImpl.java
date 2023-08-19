package com.itheima.service.impl;

import org.springframework.stereotype.Service;

import com.itheima.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	public void save() {
		System.out.println("book service is running...");
	}

}
