package cn.itcast.mp.simple.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@TableName("tb_user")
public class User extends Model<User>{
	
//	@TableId(type = IdType.AUTO)//指定id类型为自增长
	private Long id;
	private String userName;
	
	//3.查询时不返回字段的值
	@TableField(select = false)
	private String password;//字段不加入查询
	private String name;
	private Integer age;
	
	//1.对象中的属性名和字段名不一致的问题（非驼峰）
	@TableField(value="email")//解决字段名不一致，指定数据库表中的字段名
	private String mail;
	
	//2.对象中的属性字段在表中不存在的问题
	@TableField(exist = false)//在数据库表中是不存在的
	private String  address;
	
}
