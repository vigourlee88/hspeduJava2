package com.itheima.service;

import java.io.IOException;

import org.springframework.transaction.annotation.Transactional;

public interface AccountService {

//	@Transactional(rollbackFor= {IOException.class})
	@Transactional
	public void transfer(String out, String in, Double money) throws IOException;
}
