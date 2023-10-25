package com.itheima.service.impl.activemq.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {// 专门处理监听消息

	@JmsListener(destination = "order.queue.id") // 消息接收到这里面
	@SendTo("order.other.queue.id") // 接收到的消息又发到另一个里面
	public String receive(String id) {
		System.out.println("已完成短信发送业务, id: " + id);
		return "new" + id;
	}
}
