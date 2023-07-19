package com.itheima.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import com.alibaba.druid.pool.DruidDataSource;
import com.itheima.dao.BookDao;

//@Configuration
public class JdbcConfig {
	
	@Value("com.mysql.jdbc.Driver")
	private String driver;
	@Value("jdbc:mysql://localhost:3306/test18_mysql8")
	private String url;
	@Value("root")
	private String userName;
	@Value("abc123")
	private String password;
	
	
	@Bean
	//第三方引用类型依赖注入
	//只需要为bean定义方法设置形参即可，容器会根据类型自动装配对象
	public DataSource dataSource(BookDao bookDao) {
		System.out.println(bookDao);

		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(userName);
		ds.setPassword(password);
		return ds;
		
	}

}
