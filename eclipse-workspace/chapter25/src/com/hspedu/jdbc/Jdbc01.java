package com.hspedu.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

//这是一个jdbc程序，完成简单的操作
public class Jdbc01 {
	public static void main(String[] args) throws SQLException {
		
		//前置工作，在项目下创建一个文件夹比如lib
		//将 mysql.jar 拷贝到该目录下，点击build path
		//1.注册驱动
		Driver driver = new Driver();
		//2.得到连接
		//解读
		//(1)jdbc:mysql:// 规定好表示协议，通过jdbc的方式连接mysql
		//(2) localhost 主机 也可以是ip地址
		//(3) 3306表示mysql监听的端口
		//(4) hsp_db02 连接到mysql dbms的哪个数据库
		//(5)MySQL的连接本质就是前面学过的socket连接
		String url = "jdbc:mysql://localhost:3306/hsp_db02";
		//将用户名和密码放入到Properties对象
		Properties properties = new Properties();
		//user和password 会规定好的 后面的值根据实际情况写
		properties.setProperty("user", "root");
		properties.setProperty("password", "123456");
		Connection connect = driver.connect(url, properties);
		//3.执行sql语句
		//String sql = "insert into actor values(null,'刘德华','男','1970-11-11','110')";
		String sql = "update actor set name = '周星驰' where id = 1";
		//String sql = "delete from actor where id = 10";
		//用于执行静态sql语句并返回其生成的结果的对象
		//获取执行sql语句的命令对象
		Statement statement = connect.createStatement();
		//如果是dml语句，返回的就是影响行数
		//使用命令对象指向sql语句
		int rows = statement.executeUpdate(sql);
		
		//处理执行结果
		System.out.println(rows > 0 ? "成功" : "失败");
		//4.关闭资源
		statement.close();
		connect.close();
	}

}
