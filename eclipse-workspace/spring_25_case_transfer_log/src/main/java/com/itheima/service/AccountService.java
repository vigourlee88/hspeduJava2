package com.itheima.service;

import java.io.IOException;

import org.springframework.transaction.annotation.Transactional;

public interface AccountService {
	
	//1.配置当前接口方法具有事务
	//用注解做事务管理，应到SpringConfig中开启事务
	//事务属性
//	@Transactional(readOnly = true,timeout = -1)
	//rollback:设置当前事务参与回滚的异常，默认非运行时异常不参与回滚
    @Transactional(rollbackFor = IOException.class)
//	@Transactional()
	public void transfer(String out, String in, Double money) throws IOException;
}
