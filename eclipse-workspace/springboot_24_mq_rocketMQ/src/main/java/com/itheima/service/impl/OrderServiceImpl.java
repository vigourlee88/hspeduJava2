package com.itheima.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.service.MessageService;
import com.itheima.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private MessageService messageService;

	@Override
	public void order(String id) {
		// 一系列的操作，包含各种服务调用，处理各种业务
		System.out.println("订单处理开始");
		// 短信消息处理
		messageService.sendMessage(id);// id发送到消息队列中
		System.out.println("订单处理结束");
		System.out.println();
	}

}
