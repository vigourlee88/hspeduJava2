package com.itheima.service.impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;

//修改BookServiceImpl类，添加两个接口InitializingBean， DisposableBean
//并实现接口中的两个方法afterPropertiesSet和destroy
public class BookServiceImpl2 implements BookService,InitializingBean,DisposableBean {

	private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        System.out.println("set .....");
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }

    public void destroy() throws Exception {
        System.out.println("service destroy");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("service init");
    }
}
