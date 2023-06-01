package com.hspedu.jdbc.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;



public class DBUtils_USE {

	//使用apache-DUtils 工具类 + druid完成对表的CRUD操作
	
	//返回结果是多行的情况
    @Test
	public void testQueryMany() throws SQLException {
		
		//1.得到连接(druid)
		Connection connection = JDBCUtilsByDruid.getConnection();
		//2.使用 DBUtils 类和接口，先引入DBUtils相关的jar包，并build path到本项目中
		//3.创建QueryRunner
		QueryRunner queryRunner = new QueryRunner();
		//4.就可以执行相关的方法，返回ArrayList结果集
		//String sql = "select * from actor where id >= ?";
		//注意:sql语句也可以查询部分 列
		String sql = "select id,name from actor where id >= ?";
		//解读
		//(1)query() 就是执行sql语句，得到resultSet--封装到--ArrayList集合中
		//(2)返回
		//(3)connection: 连接
		//(4)sql:执行的SQL语句
		//(5)new BeanListHandler<>(Actor.class):
		//告诉底层最终把怎样的对象(Actor.class)放入到ArrayList中,
		//在将resultSet=>Actor对象 =>封装到ArrayList中
		//底层使用反射机制 去获取到Actor类 的各个属性，然后封装
		//(6)1 就是给sql语句中的 ? 赋值，可以有多个值 1,2,3 因为是可变参数Object...params
		//(7)底层得到resultSet，会在query关闭，关闭PreparedStatement
		/*
		 * public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh,
            Object... params) throws SQLException {

		        PreparedStatement stmt = null;//定义一个PreparedStatement对象
		        ResultSet rs = null;//接收返回的结果集
		        T result = null;//返回ArrayList
		
		        try {
		            stmt = this.prepareStatement(conn, sql);//创建PreparedStatement
		            this.fillStatement(stmt, params);//对sql进行?赋值
		            rs = this.wrap(stmt.executeQuery());//执行sql,返回resultSet
		            result = rsh.handle(rs);//返回的resultSet=>ArrayList
		
		        } catch (SQLException e) {
		            this.rethrow(e, sql, params);
		
		        } finally {
		            try {
		                close(rs);//关闭resultSet
		            } finally {
		                close(stmt);//关闭preparedstatement对象
		            }
		        }
		
		        return result;
		    } 
		 */
		List<Actor> list = 
				queryRunner.query(connection,sql,new BeanListHandler<>(Actor.class),1);
		System.out.println("输出集合的信息");
		for(Actor actor : list) {
			System.out.print(actor);
		}
		
		//释放资源
		JDBCUtilsByDruid.close(null,null,connection);
	}
    
    //演示 apache-dbutils + druid 完成 返回的结果是单行记录(单个对象)
    @Test
    public void testQuerySingle() throws SQLException {
    	//1.得到连接
    	Connection connection = JDBCUtilsByDruid.getConnection();
    	//2.使用DBUils类和接口
    	//3.创建QueryRunner
    	QueryRunner queryRunner = new QueryRunner();
    	//4.执行相关方法，返回单个对象
    	String sql ="select id,name from actor where id = ?";
    	
    	//因为我们返回的单行记录 是 单个对象，使用的Hander是BeanHandler
    	Actor actor = queryRunner.query(connection,sql,new BeanHandler<>(Actor.class),4);//给?赋值4
    	System.out.print(actor);
    	
    	//释放资源
    	JDBCUtilsByDruid.close(null, null, connection);
    	
    }
    
    //演示apache-dbutils + druid 完成查询结果是单行单列 -返回的就是object
    @Test
    public void testScalar() throws SQLException {
    	//1.得到连接
    	Connection connection = JDBCUtilsByDruid.getConnection();
    	//2.使用DBUils类和接口
    	//3.创建QueryRunner
    	QueryRunner queryRunner = new QueryRunner();
    	//4.执行相关方法，返回单行单列，返回就是object
    	String sql ="select name from actor where id = ?";
    	
    	//因为我们返回的单行记录 是 单个对象，使用的Hander是BeanHandler
    	Object obj = queryRunner.query(connection,sql,new ScalarHandler(),4);//给?赋值4
    	System.out.println(obj);
    	
    	//释放资源
    	JDBCUtilsByDruid.close(null, null, connection);
    	
    }
    
    //演示apache-dbutils + druid 完成dml操作(update,delete,insert)
    @Test
    public void testDML() throws SQLException {
    	//1.得到连接
    	Connection connection = JDBCUtilsByDruid.getConnection();
    	//2.使用DBUtils类和接口
    	//3.创建QueryRunner
    	QueryRunner queryRunner = new QueryRunner();
    	
    	//4.这里组织sql语句 完成dml
    	//String sql = "update actor set name = ? where id = ?";
    	//String sql = "insert into actor values(null,?,?,?,?)";
    	String sql = "delete from actor where id = ?";
    	
    	//解读
    	//(1) 执行dml操作是queryRunner.update()
    	//(2)返回的值是受影响的行数(生效的行数)
    	//int affectedRow = queryRunner.update(connection,sql,"张三丰",4);
    	//int affectedRow = queryRunner.update(connection,sql,"林青霞","女","1966-10-10","116");
    	int affectedRow = queryRunner.update(connection,sql,5);
    	System.out.println(affectedRow > 0 ? "执行成功":"执行没有影响到表");
    	
    	//释放资源
    	JDBCUtilsByDruid.close(null, null, connection);
    	
    }
    
}
