package com.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Override
	@Cached(name = "book_", key = "#id", expire = 3600, cacheType = CacheType.REMOTE)
//    @CacheRefresh(refresh = 5)　设置缓存刷新
	public Book getById(Integer id) {
		return bookDao.selectById(id);
	}

	@Override
	public boolean save(Book book) {
		return bookDao.insert(book) > 0;
	}

	@Override
	// 调用这个方法时，更新缓存 更新缓存中key= "#book.id" 的值，用#book替换
	@CacheUpdate(name = "book_", key = "#book.id", value = "#book")
	public boolean update(Book book) {
		return bookDao.updateById(book) > 0;
	}

	@Override
	// 删除同步
	@CacheInvalidate(name = "book_", key = "#id")
	public boolean delete(Integer id) {
		return bookDao.deleteById(id) > 0;
	}

	@Override
	public List<Book> getAll() {
		return bookDao.selectList(null);
	}
}
