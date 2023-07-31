package com.itheima.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itheima.domain.Book;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@PostMapping
	public String save(@RequestBody Book book) {
		System.out.println("book save -->"+ book);
		return "{'module':'book save success'}";
	}
    
	@GetMapping
	public List<Book> getAll() {
		System.out.println("book getAll is running...");
		
		List<Book> bookList = new ArrayList<Book>();
		
		Book book1 = new Book();
		book1.setType("计算机");
		book1.setName("springMVC实战教育");
		book1.setDescription("一代宗师");
		bookList.add(book1);
		
		Book book2 = new Book();
		book2.setType("计算机");
		book2.setName("springMVC入门教育");
		book2.setDescription("小试牛刀");
		bookList.add(book2);
		
		return bookList;		
	}

}
