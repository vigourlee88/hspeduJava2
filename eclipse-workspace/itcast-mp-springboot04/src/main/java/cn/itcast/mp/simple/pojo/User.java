package cn.itcast.mp.simple.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import cn.itcast.mp.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@TableName("tb_user")
//@KeySequence(value = "SEQ_USER",clazz = Long.class)
public class User extends Model<User>{
	
//	@TableId(type = IdType.AUTO)//指定id类型为自增长
	private Long id;
	private String userName;
	
	//3.查询时不返回字段的值,插入数据时，自动填充
	@TableField(select = false,fill = FieldFill.INSERT)
	private String password;//字段不加入查询
	private String name;
	private Integer age;
	
	//1.对象中的属性名和字段名不一致的问题（非驼峰）
	@TableField(value="email")//解决字段名不一致，指定数据库表中的字段名
	private String mail;
	
	//2.对象中的属性字段在表中不存在的问题
	@TableField(exist = false)//在数据库表中是不存在的
	private String  address;
	
	@Version //乐观锁的版本字段
	private Integer version;
	
	@TableLogic //逻辑删除字段，1-删除，2-未删除
	private Integer deleted;
	
	private SexEnum sex;//性别，枚举类型
	
}
