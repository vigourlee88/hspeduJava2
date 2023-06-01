package com.hspedu.jdbc.datasource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

//测试druid的使用
public class Druid_ {

	@Test
	public void testDruid() throws Exception {
		// 1.加入Druid的jar包
		// 2.加入配置文件 druid.properties,将文件拷贝到src目录下
		// 3.创建Properties对象，读取配置文件信息
		Properties properties = new Properties();
		properties.load(new FileInputStream("src//druid.properties"));

		// 4.创建一个指定参数的数据库连接池,Druid连接池
		DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

		long start = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			Connection connection = dataSource.getConnection();// 得到数据源，获得连接、
			//System.out.println("连接成功!");
			connection.close();
		}
		long end = System.currentTimeMillis();
		System.out.println("druid连接池 操作500000次 耗时=" + (end - start));//2014
	}

}
