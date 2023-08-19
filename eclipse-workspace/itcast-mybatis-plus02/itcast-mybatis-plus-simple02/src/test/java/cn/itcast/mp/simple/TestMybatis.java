package cn.itcast.mp.simple;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mp.simple.mapper.UserMapper;
import cn.itcast.mp.simple.pojo.User;


public class TestMybatis {
	
	@Test
	public void testFindAll() throws IOException {
		String config = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(config);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//测试查询
		List<User> list = userMapper.findAll();
		for(User user : list) {
			System.out.println(user);
		}
		
	}

}
