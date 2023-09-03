package cn.itcast.mp;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.itcast.mp.simple.mapper.UserMapper;
import cn.itcast.mp.simple.pojo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMybatisSpringBoot {
	
		@Autowired
		private UserMapper userMapper;
		
		@Test
		public void testSelect() {
			List<User> userList = userMapper.selectList(null);
			for (User user : userList) {
			System.out.println(user);
		}
	}

}
