package com.itheima.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

public class JdbcConfig {
	
	@Value("${jdbc.driver}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	
	@Bean
	public DataSource dataSource() {
		 DruidDataSource dataSource = new DruidDataSource();
		 dataSource.setDriverClassName(driver);
		 dataSource.setUrl(url);
		 dataSource.setUsername(username);
		 dataSource.setPassword(password);
		 return dataSource;
		
	}

	@Bean
	//平台事务管理器
	public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
		DataSourceTransactionManager ds = new DataSourceTransactionManager();
		ds.setDataSource(dataSource);
		return ds;
	}
}
