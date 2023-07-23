package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.itheima")
@PropertySource("jdbc.properties")
@Import({JdbcConfig.class,MyBatisConfig.class})
//3.告诉开启注解式事务驱动
@EnableAspectJAutoProxy
public class SpringConfig {

}
