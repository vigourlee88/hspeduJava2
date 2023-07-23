package com.itheima.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.dao.ResourcesDao;
import com.itheima.service.ResourcesService;

@Service
public class ResourcesServiceImpl implements ResourcesService{

	@Autowired
	private ResourcesDao resourcesDao;
	
	public boolean openURL(String url, String password) {
		
		return resourcesDao.readResources(url,password);
	}

}
