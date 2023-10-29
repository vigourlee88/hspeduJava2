package com.itheima.service.impl;

import org.springframework.stereotype.Service;

import com.itheima.service.BookService;

@Service("bookService")
public class BookServiceImpl1 implements BookService {

	@Override
	public void check() {
		System.out.println("book service 1..");
	}

}
