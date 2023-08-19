package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itheima.service.BookService;

@SpringBootTest
class Springboot07TestApplicationTests {
	//注入测试对象
	@Autowired
	private BookService bookService;
	
	@Test
	void contextLoads() {
		bookService.save();
	}

}
