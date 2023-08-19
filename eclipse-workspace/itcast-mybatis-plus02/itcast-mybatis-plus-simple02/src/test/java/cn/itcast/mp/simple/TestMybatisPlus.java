package cn.itcast.mp.simple;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;

import cn.itcast.mp.simple.mapper.UserMapper;
import cn.itcast.mp.simple.pojo.User;


public class TestMybatisPlus {
	
	@Test
	public void testFindAll() throws IOException {
		String config = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(config);
		//使用MP中的MybatisSqlSessionFactoryBuilder进程构建：
		//完成mybatis和mp插件的整合
		SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//测试查询
//		List<User> list = userMapper.findAll();
		// 可以调用BaseMapper中定义的方法
		List<User> list = userMapper.selectList(null);
		for(User user : list) {
			System.out.println(user);
		}
		
	}

}
