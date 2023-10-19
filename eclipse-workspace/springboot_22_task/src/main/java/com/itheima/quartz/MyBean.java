package com.itheima.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
//2.要定时干的事情，写上@Scheduled
public class MyBean {

	@Scheduled(cron = "0/1 * * * * ?") // 指定时间执行
	public void print() {
		System.out.println(Thread.currentThread().getName() + " :spring task run...");
	}

}
