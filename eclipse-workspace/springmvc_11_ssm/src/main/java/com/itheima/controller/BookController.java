package com.itheima.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itheima.domain.Book;
import com.itheima.service.BookServive;

@RestController
//控制器类
@RequestMapping("/books")
//配置模块映射
public class BookController {
	
	@Autowired
	private BookServive bookServive;
	
	@PostMapping
	public boolean save(@RequestBody Book book) {
		return bookServive.save(book);
		
	}

	@PutMapping
	public boolean update(@RequestBody Book book) {
		return bookServive.update(book);
		
	}

	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable Integer id) {
		return bookServive.delete(id);
		
	}

	@GetMapping("/{id}")
	public Book getById(@PathVariable Integer id) {
		
		return bookServive.getById(id);
	}

	@GetMapping
	public List<Book> getAll() {
		
		return bookServive.getAll();
	}


}
