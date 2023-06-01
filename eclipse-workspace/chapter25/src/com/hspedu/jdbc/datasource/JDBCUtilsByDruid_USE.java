package com.hspedu.jdbc.datasource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;


public class JDBCUtilsByDruid_USE {

	@Test
	public void testSelect() {
		//1.得到连接
		Connection connection = null;
		//2.组织sql语句
		String sql = "select * from actor where id >= ?";
		//测试select 语句 应该定义一个ResultSet对象
		ResultSet set = null;
		
		//3.创建PreparedStatement对象
		PreparedStatement preparedStatement = null;
		try {
			connection = JDBCUtilsByDruid.getConnection();
			//connextion 运行类型是DruidPooledConnection
			System.out.println(connection.getClass());
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 1);//给?赋值
			//有 占位符? 的话，需要赋值
			
			//执行,得到结果集
			set = preparedStatement.executeQuery();
			//遍历该结果集
			while(set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				String sex = set.getString("sex");
				Date borndate = set.getDate("borndate");
				String phone = set.getString("phone");
				System.out.println(id + "\t" + name + "\t" +
						           sex + "\t" + borndate + "\t" +
						           phone + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//3.关闭资源
			JDBCUtilsByDruid.close(set, preparedStatement, connection);
		}
	}
	
	//使用土方法来解决把ResultSet 封装到=>ArrayList 
	@Test
	public ArrayList<Actor> testSelectToArrayList() {
		//1.得到连接
		Connection connection = null;
		//2.组织sql语句
		String sql = "select * from actor where id >= ?";
		//测试select 语句 应该定义一个ResultSet对象
		ResultSet set = null;
		//创建一个ArrayList对象，用来存放actor对象
		ArrayList<Actor> list = new ArrayList<>();
		
		//3.创建PreparedStatement对象
		PreparedStatement preparedStatement = null;
		try {
			connection = JDBCUtilsByDruid.getConnection();
			//connextion 运行类型是DruidPooledConnection
			System.out.println(connection.getClass());
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 1);//给?赋值
			//有 占位符? 的话，需要赋值
			
			//执行,得到结果集
			set = preparedStatement.executeQuery();
			//遍历该结果集
			while(set.next()) {
				int id = set.getInt("id");
				String name = set.getString("name");
				String sex = set.getString("sex");
				Date borndate = set.getDate("borndate");
				String phone = set.getString("phone");
				//把得到的resultSet 的记录，封装到Actor对象，放入到list集合中
				list.add(new Actor(id,name,sex,borndate,phone));
			}
			
			System.out.println("list集合数据=" + list);
			for(Actor actor : list) {
				System.out.println("name=" + actor.getName() + "\t" + actor.getId());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//3.关闭资源
			JDBCUtilsByDruid.close(set, preparedStatement, connection);
		}
		//因为ArrayList和connection 没有任何关联，所以该集合可以复用
        return list;
	}
}
