package com.itheima.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

public class MyBatisConfig {
	    @Bean
	    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
	        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
	        factory.setTypeAliasesPackage("com.itheima.domain");
	        factory.setDataSource(dataSource);
	        return factory;
	    }

	    @Bean
	    public MapperScannerConfigurer mapperScannerConfigurer(){
	        MapperScannerConfigurer msc = new MapperScannerConfigurer();
	        msc.setBasePackage("com.itheima.dao");
	        return msc;
	    }

}
