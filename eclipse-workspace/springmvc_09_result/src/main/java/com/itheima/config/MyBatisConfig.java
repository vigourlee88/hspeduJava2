package com.itheima.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.MappingJsonFactory;

public class MyBatisConfig {
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
		 SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		 factoryBean.setDataSource(dataSource);
		 //类型别名的扫描包
		 factoryBean.setTypeAliasesPackage("com.itheima.domain");
		 return factoryBean;
	}

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer msc = new MapperScannerConfigurer();
		msc.setBasePackage("com.itheima.dao");
		return msc;
	}
}