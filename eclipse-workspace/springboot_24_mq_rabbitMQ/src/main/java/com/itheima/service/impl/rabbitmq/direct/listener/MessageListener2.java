package com.itheima.service.impl.rabbitmq.direct.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

//@Component
public class MessageListener2 {// 监听器

	@RabbitListener(queues = "direct_queue") // 绑定队列名称
	public void receive(String id) {
		System.out.println("已完成短信发送业务(rabbitmq direct two), id: " + id);
	}

}
