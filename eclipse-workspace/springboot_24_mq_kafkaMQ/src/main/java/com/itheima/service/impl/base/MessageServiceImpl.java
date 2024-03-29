package com.itheima.service.impl.base;

import java.util.ArrayList;

import com.itheima.service.MessageService;

//@Service
public class MessageServiceImpl implements MessageService {

	private ArrayList<String> msgList = new ArrayList<String>();

	@Override
	public void sendMessage(String id) {
		System.out.println("待发送短信的订单已纳入队列,id: " + id);
		msgList.add(id);
	}

	@Override
	public String doMessage() {
		String id = msgList.remove(0);// 从第一位处理
		System.out.println("已完成短信发送业务, id: " + id);
		return id;
	}

}
