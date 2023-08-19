package cn.itcast.mp.simple.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_user")

public class User {
	private Long id;
	private String userName;
	private String password;
	private String name;
	private Integer age;
	private String email;
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", name=" + name + ", age="
				+ age + ", email=" + email + "]";
	}
	

}
