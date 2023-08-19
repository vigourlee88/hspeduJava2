package com.itheima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Result save(@RequestBody Book book) {
		boolean flag = bookServive.save(book);
		return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
		
	}

	@PutMapping
	public Result update(@RequestBody Book book) {
		boolean flag = bookServive.update(book);
		return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
		
	}

	@DeleteMapping("/{id}")
	public Result delete(@PathVariable Integer id) {
		boolean flag = bookServive.delete(id);
		return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
	
	}

	@GetMapping("/{id}")
	public Result getById(@PathVariable Integer id) {
		
		Book book = bookServive.getById(id);
		Integer code = book != null ? Code.GET_OK:Code.GET_ERR;
		String msg = book != null ? "":"数据查询失败，请重试!";
		return new Result(code,book,msg);
	
	}

	@GetMapping
	public Result getAll() {
		 
	    List<Book> bookList = bookServive.getAll();
		Integer code = bookList != null ? Code.GET_OK:Code.GET_ERR;
		String msg = bookList != null ? "":"数据查询失败，请重试!";
		return new Result(code,bookList,msg);
	
	}


}
