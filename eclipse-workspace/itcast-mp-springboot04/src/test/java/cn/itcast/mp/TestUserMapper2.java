package cn.itcast.mp;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.validator.PublicClassValidator;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import cn.itcast.mp.enums.SexEnum;
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
		user.setUserName("diaochan");
		user.setPassword("123456");
		user.setAge(20);
		user.setName("貂蝉");
		user.setMail("diaochan@itcast.cn");
		user.setVersion(1);
		user.setSex(SexEnum.WOMAN);//使用枚举类型
		
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
	
	/**
	 * 测试乐观锁
	 */
	@Test
	public void testUpdateVersion() {
		User user = new User();
		user.setId(2L);//查询条件
		
//		User userVersion = user.selectById();

        user.setAge(23); // 更新的数据
        user.setVersion(1); // 当前的版本信息
        
		boolean result = user.updateById();
		System.out.println("result=> " + result);
	}
	
	/**
	 * 测试全表更新，SQL分析器阻断效果
	 */
	@Test
	public void testUpdateAll() {
		User user = new User();
		user.setAge(31);//更新数据
				
		boolean result = user.update(null);//全表更新
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
	
	@Test
	public void testSelectBysex() {
		User user = new User();
	
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.ge("sex",SexEnum.WOMAN);//查询性别为女的数据
		
		List<User> users = user.selectList(wrapper);
		for (User user1 : users) {
			System.out.println(user1);
		}
	}
}
