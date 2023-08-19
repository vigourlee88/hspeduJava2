package com.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.controller.Code;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.exception.BusinessException;
import com.itheima.service.BookServive;

@Service
public class BookServiceImpl implements BookServive {

	@Autowired
	//自动装配
	private BookDao bookDao;
	
	public boolean save(Book book) {

		return bookDao.save(book) > 0;
	}

	
	public boolean update(Book book) {
		return bookDao.update(book) > 0;
		
	}

	
	public boolean delete(Integer id) {
		return bookDao.delete(id) > 0;
		
	}

	
	public Book getById(Integer id) {
		if(id == 1) {
			throw new BusinessException(Code.BUSINESS_ERR, "请不要使用你的技术挑战我的耐性");
		}
		
		return bookDao.getById(id);
	}

	
	public List<Book> getAll() {
		
		return bookDao.getAll();
	}

}
