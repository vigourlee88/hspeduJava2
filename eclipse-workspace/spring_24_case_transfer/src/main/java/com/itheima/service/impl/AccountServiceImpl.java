package com.itheima.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	protected AccountDao accountDao;
	
	public void transfer(String out,String in,Double money) {
		accountDao.outMoney(out,money);
	int i = 1/0;
		accountDao.inMoney(in, money);
	}
	

}
