package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.itheima.service")
@PropertySource("classpath:jdbc.properties")
//加载配置文件
@Import({JdbcConfig.class,MyBatisConfig.class})
//加载配置类
@EnableTransactionManagement
public class SpringConfig {
}
