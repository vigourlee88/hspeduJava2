package com.itheima.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.itheima.dao.BookDao;

//组件，代表<bean id="bookdao" />,数据仓库,控制层
//@Component("bookDao")
@Repository("bookDao")
//@Controller
public class BookDaoImpl implements BookDao{

	public void save() {
		System.out.println("book dao save...");
	}
	

}
