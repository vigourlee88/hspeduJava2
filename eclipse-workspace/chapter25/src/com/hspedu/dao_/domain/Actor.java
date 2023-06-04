package com.hspedu.dao_.domain;


//Actor对象和actor表的记录对应
public class Actor {
	
	//5个字段对应actor表的5列
	private Integer id;//对象对应对象
	private String name;
	private String sex;
	private String borndate;//这里util包下
	private String phone;
	//一定要给一个无参构造器，底层反射会用到
	public Actor() {
		super();
	}
	public Actor(Integer id, String name, String sex, String borndate, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.borndate = borndate;
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBorndate() {
		return borndate;
	}
	public void setBorndate(String borndate) {
		this.borndate = borndate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "\nActor [id=" + id + ", name=" + name + ", sex=" + sex + ", borndate=" + borndate +", phone=" + phone
				+ "]";
	}
	
	
}
