package cn.itcast.mp.simple;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.itcast.mp.simple.mapper.UserMapper;
import cn.itcast.mp.simple.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")

public class TestSpringMp {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testSelectList() {
		List<User> list = this.userMapper.selectList(null);
		for(User user : list) {
			System.out.println(user);
		}
	}

}
