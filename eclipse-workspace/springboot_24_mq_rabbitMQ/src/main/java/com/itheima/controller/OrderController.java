package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itheima.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {// 表现层显示出来

	@Autowired
	private OrderService orderService;

	@PostMapping("{id}")
	public void order(@PathVariable String id) {
		orderService.order(id);
	}

}
