package com.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookServive;

@Service
public class BookServiceImpl implements BookServive {

	@Autowired
	//自动装配
	private BookDao bookDao;
	
	public boolean save(Book book) {
		bookDao.save(book);
		return true;
	}

	
	public boolean update(Book book) {
		bookDao.update(book);
		return true;
	}

	
	public boolean delete(Integer id) {
		bookDao.delete(id);
		return true;
	}

	
	public Book getById(Integer id) {
		
		return bookDao.getById(id);
	}

	
	public List<Book> getAll() {
		
		return bookDao.getAll();
	}

}
