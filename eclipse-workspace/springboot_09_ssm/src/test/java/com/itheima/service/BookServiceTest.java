package com.itheima.service;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itheima.domain.Book;


@SpringBootTest
public class BookServiceTest {
	
	@Autowired
	private BookServive bookService;
	
	@Test
	public void testGetById() {
		Book book = bookService.getById(2);
		System.out.println(book);
	}
	
	@Test
	public void testGetAll() {
		List<Book> all = bookService.getAll();
		System.out.println(all);
	}

}
