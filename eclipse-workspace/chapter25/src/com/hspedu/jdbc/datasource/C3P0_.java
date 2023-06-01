package com.hspedu.jdbc.datasource;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.jupiter.api.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//演示c3p0的使用
public class C3P0_ {

	// 方式1:相关参数，在程序中指定user,password,url....
	@Test
	public void testC3P0_01() throws FileNotFoundException, IOException, PropertyVetoException, SQLException {
		// 1.创建一个数据源对象
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		// 2.通过配置文件mysql.properties获取相关信息
		Properties properties = new Properties();
		properties.load(new FileInputStream("src//mysql.properties"));
		// 读取相关的属性值
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String url = properties.getProperty("url");
		String driver = properties.getProperty("driver");

		// 给数据源(连接池) comboPooledDataSource 设置相关的参数
		// 注意:连接管理是由comboPooledDataSource来管理
		comboPooledDataSource.setDriverClass(driver);
		comboPooledDataSource.setJdbcUrl(url);
		comboPooledDataSource.setUser(user);
		comboPooledDataSource.setPassword(password);

		// 设置初始化连接数
		comboPooledDataSource.setInitialPoolSize(10);
		// 最大连接数
		comboPooledDataSource.setMaxPoolSize(50);
		// 测试连接池的效率，对mysql 5000次操作
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			// 核心方法 就是从DataSource接口实现的
			Connection connection = comboPooledDataSource.getConnection();
			// System.out.println("连接ok");
			connection.close();
		}
		long end = System.currentTimeMillis();
		System.out.println("c3p0 5000连接mysql 耗时=" + (end - start));

	}

	// 第二种方式 使用配置文件模板来完成

	// 1.将c3p0.config.xml拷贝到src目录下
	// 2.该文件指定了连接数据库和连接池的相关参数
	@Test
	public void testC3P0_02() throws SQLException {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("hsp_edu");// 配置文件中 数据源名称hsp_edu

		// 测试5000次连接mysql
		long start = System.currentTimeMillis();
		System.out.println("开始执行....");
		for (int i = 0; i < 500000; i++) {
			Connection connection = comboPooledDataSource.getConnection();
			//System.out.println("连接ok~~~");
			connection.close();
		}
		long end = System.currentTimeMillis();
		System.out.println("c3p0的第二种方式 耗时=" + (end - start));//4367
	}
}
