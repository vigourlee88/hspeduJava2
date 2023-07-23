package com.itheima.dao.impl;

import org.springframework.stereotype.Repository;

import com.itheima.dao.ResourcesDao;

@Repository
public class ResourcesDaoImpl implements ResourcesDao{

	public boolean readResources(String url, String password) {
		System.out.println(password.length());
		//模拟校验
		return password.equals("root");
	}

}
