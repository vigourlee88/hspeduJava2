package com.itheima.service.impl.rabbitmq.direct.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

//@Configuration
public class RabbitConfigDirect {
	@Bean
	public Queue directQueue() {// 消息队列
		return new Queue("direct_queue");
	}

	@Bean
	public Queue directQueue2() {
		return new Queue("direct_queue2");
	}

	@Bean
	public DirectExchange directExchange() {// 交换机对象DirectExchange
		return new DirectExchange("directExchange");
	}

	@Bean
	public Binding bindingDirect() {// 绑定关系的对象binding
		return BindingBuilder.bind(directQueue()).to(directExchange()).with("direct");
	}

	@Bean
	public Binding bindingDirect2() {
		return BindingBuilder.bind(directQueue2()).to(directExchange()).with("direct2");
	}

}
