package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;

@SpringBootTest
class Springboot08MybatisApplicationTests {

	@Autowired
	private BookDao bookDao;
	
	@Test
	void testGetById() {
		
		Book book = bookDao.getById(1);
		System.out.println(book);
		
	}

}
