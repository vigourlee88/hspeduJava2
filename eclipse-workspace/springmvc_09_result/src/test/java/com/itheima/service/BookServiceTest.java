package com.itheima.service;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Book;



@RunWith(SpringJUnit4ClassRunner.class)
//指配置类上下文
@ContextConfiguration(classes = SpringConfig.class)
//业务层测试使用spring整合junit
public class BookServiceTest {
	
	@Autowired
	private BookServive bookService;
	
	@Test
	public void testGetById() {
		Book book = bookService.getById(1);
		System.out.println(book);
	}
	
	@Test
	public void testGetAll() {
		List<Book> all = bookService.getAll();
		System.out.println(all);
	}

}
