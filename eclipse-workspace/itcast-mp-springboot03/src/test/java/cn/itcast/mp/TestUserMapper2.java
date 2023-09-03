package cn.itcast.mp;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.validator.PublicClassValidator;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.itcast.mp.simple.pojo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserMapper2 {
	
	@Test
	public void TestSelectById() {
		//User extends Model<User>,里面有很多方法
		User user = new User();
		user.setId(2L);
		
		User user1 = user.selectById();
		System.out.println(user1);
		
	}
	
	@Test
	public void testInsert() {
		User user = new User();
		user.setUserName("liubei");
		user.setPassword("123456");
		user.setAge(30);
		user.setName("刘备");
		user.setMail("liubei@itcast.cn");
		
		//调用AR的insert方法进行插入数据
		boolean insert = user.insert();
		System.out.println("result => " + insert);
	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(14L);//查询条件
		user.setAge(31);//更新数据
				
		boolean result = user.updateById();
		System.out.println("result=> " + result);
	}
	
	@Test
	public void testDelete() {
		User user = new User();
		user.setId(14L);
		
		boolean delete = user.deleteById();
		System.out.println("result=> " + delete);
	}
	
	@Test
	public void testSelect() {
		User user = new User();
		//SELECT id,user_name,name,age,email AS mail FROM tb_user WHERE age >= ? 
		//根据条件查询
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.ge("age",30);//条件大于等于30岁的用户查询
		
		List<User> users = user.selectList(wrapper);
		for (User user1 : users) {
			System.out.println(user1);
		}
	}
}
