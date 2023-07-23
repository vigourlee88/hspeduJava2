package com.itheima.service;

import org.springframework.transaction.annotation.Transactional;

public interface AccountService {
	/**
	 * 转账操作
	 * @param out 转出方
	 * @param in  转入方
	 * @param money  金额
	 */
	
	//1.配置当前接口方法具有事务
	//用注解做事务管理，应到SpringConfig中开启事务
	@Transactional
	public void transfer(String out, String in, Double money);
}
