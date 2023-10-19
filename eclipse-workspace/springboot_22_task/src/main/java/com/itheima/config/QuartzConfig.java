package com.itheima.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.ScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.itheima.quartz.MyQuartz;

@Configuration
public class QuartzConfig {

	@Bean
	public JobDetail printJobDetail() {// 工作明细
		// 绑定具体的工作
		return JobBuilder.newJob(MyQuartz.class).storeDurably().build();// storeDurably()做持久化
	}

	@Bean
	public Trigger printJobTrigger() {// 触发器
		ScheduleBuilder schedBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
		// 绑定对应的工作明细
		return TriggerBuilder.newTrigger().forJob(printJobDetail()).withSchedule(schedBuilder).build();// forJob绑定任务
	}

}
