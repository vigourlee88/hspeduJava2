package com.itheima.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import com.itheima.service.LogService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	//用业务层调用自动装配
	private LogService logService;
	
	
	public void transfer(String out,String in,Double money)  {
		try {
			
			//一定运行的代码
			accountDao.outMoney(out, money);
			
			int i = 1/0;
			
			accountDao.inMoney(in, money);
		} finally {
			logService.log(out, in, money);
		}
	}
	
}
