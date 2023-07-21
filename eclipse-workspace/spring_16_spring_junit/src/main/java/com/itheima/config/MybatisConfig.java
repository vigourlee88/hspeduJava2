package com.itheima.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

public class MybatisConfig {
	
	@Bean
	//造对象SqlSessionFactoryBean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        
		//定义bean，SqlSessionFactoryBean，用于产生SqlSessionFactory对象
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        
        //设置模型 类的别名扫描
        sqlSessionFactory.setTypeAliasesPackage("com.itheima.domain");
        //设置数据源
        sqlSessionFactory.setDataSource(dataSource);//@Bean注解注入引用类型，参数中加入对应参数DataSource
        return sqlSessionFactory;
    }
	
    //定义bean，返回MapperScannerConfigurer对象
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        //映射在哪个包下
        msc.setBasePackage("com.itheima.dao");
        return msc;
        
    }

}
