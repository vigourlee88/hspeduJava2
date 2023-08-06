package com.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.controller.Code;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import com.itheima.service.BookServive;

@Service
public class BookServiceImpl implements BookServive {

	@Autowired
	//自动装配
	private BookDao bookDao;
	
	public boolean save(Book book) {
//		bookDao.save(book);
//		return true;
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
//		//将可能出现的异常进行包装，转换成自定义的异常
//		try {
//			int i = 1/0;
//		} catch (Exception e) {
//			throw new SystemException(Code.SYSTEM_TIMEOUT_ERR, "服务器访问超时，请重试!",e);
//		}
		
		return bookDao.getById(id);
	}

	
	public List<Book> getAll() {
		
		return bookDao.getAll();
	}

}
