package com.hspedu.jdbc.conn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.jupiter.api.Test;

import com.mysql.cj.jdbc.Driver;

//分析java连接mysql的5种方式
public class JdbcConn {
	
	@Test
	public void connect01() throws SQLException {
		//1.创建driver对象，得到驱动
		Driver driver = new Driver();
		String url = "jdbc:mysql://localhost:3306/hsp_db02";
		//将用户名和密码放入到Properties对象
		Properties properties = new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "123456");
		//2.获得连接
		Connection connect = driver.connect(url, properties);
		System.out.println(connect);
		
	}
	
	//方式1 会直接使用com.mysql.jdbc.Driver()
	//属于静态加载，灵活性差，依赖强
	//方式2 
	
	@Test
	public void connect02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		//使用反射加载Driver类的Class对象
		//动态加载，更加灵活，减少依赖性
		Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
		//Object o = aClass.newInstance();
		Driver driver = (Driver) aClass.newInstance();
		String url = "jdbc:mysql://localhost:3306/hsp_db02";
		//将用户名和密码放入到Properties对象
		Properties properties = new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "123456");
		//2.获得连接
		Connection connect = driver.connect(url, properties);
		System.out.println(connect);
	}	
	//方式3
	@Test
	public void connect03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		//使用加载Driver,得到Class对象
		Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
	    Driver driver = (Driver) aClass.newInstance();
	    
	    //创建url和user和password
	    String url = "jdbc:mysql://localhost:3306/hsp_db02";
	    String user = "root";
	    String password = "123456";
	    
	    DriverManager.registerDriver(driver);//注册Driver驱动
	    
	    Connection connection = DriverManager.getConnection(url, user, password);
	    System.out.println("第三种方式="+connection);
	}
	
	//方式4:使用Class.forName()自动完成注册，简化代码
	//这种方式推荐使用
	@Test
	public void connect04() throws ClassNotFoundException, SQLException {
		//使用反射加载Driver类
		//在加载Driver类时，完成注册
		/*
		 *  源码:1.静态代码块，在类加载时，会执行一次
		 *  2.DriverManager.registerDriver(new Driver());
		 *  3.因此底层驱动加载注册driver的工作，已经完成
		 *  static {
		 *      try{
		 *          DriverManager.registerDriver(new Driver());
		 *       }catch(SQLException e){
		 *         throw new RuntimeException("Can't register driver!");
		 *       }
		 *   }
		 *   
		 */
		//Class.forName("com.mysql.jdbc.Driver");
		
		//创建url和user和password
	    String url = "jdbc:mysql://localhost:3306/hsp_db02";
	    String user = "root";
	    String password = "123456";
	    Connection connection = DriverManager.getConnection(url, user, password);
	    
	    System.out.println("第4中方式="+connection);
	}
	
	//方式5，在方式4的基础上改进，增加配置文件，让连接mysql更加灵活
	@Test
	public void connect05() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		//通过Properties对象获取配置文件的信息
		Properties properties = new Properties();
		properties.load(new FileInputStream("src//mysql.properties"));
		//获取相关的值
		String user = properties.getProperty("user");
      	String password = properties.getProperty("password");
      	String driver = properties.getProperty("driver");
      	String url = properties.getProperty("url");
      	
      	//加载驱动
      	//Class.forName("com.mysql.jdbc.driver");
      	Class.forName(driver);
      	 	
      	Connection connection = DriverManager.getConnection(url, user, password);
	
      	System.out.println("方式5 "+ connection);
	}

}
