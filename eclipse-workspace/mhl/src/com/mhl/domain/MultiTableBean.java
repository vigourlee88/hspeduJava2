package com.mhl.domain;

//这是一个javabean 可以和多张表进行对应
public class MultiTableBean {
	private Integer id;
	private String billId;
	private Integer menuId;
	private Integer nums;
	private Double money;
	private Integer diningTableId;
	private String billDate;
	private String state;
	//增加一个来自menu表的列name
	//思考 这里的属性名是否一定要和表的列名保持一致
	//答 可以不一致,但是需要sql做相应的修改，规范需要保持一致
	private String name;
	//增加来自menu表的列price
	private Double price;//默认值为 null
	
	public MultiTableBean() {
		System.out.println("反射调用...");
	}
	
	
//	public MultiTableBean(Integer id, String billId, Integer menuId, Integer nums, Double money, Integer diningTableId,
//			String billDate, String state, String name, Double price) {
//		super();
//		this.id = id;
//		this.billId = billId;
//		this.menuId = menuId;
//		this.nums = nums;
//		this.money = money;
//		this.diningTableId = diningTableId;
//		this.billDate = billDate;
//		this.state = state;
//		this.name = name;
//		this.price = price;
//	}
	
	//给price 生成setter和getter方法
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	//给name 生成setter和getter方法 
		//JDBC反射底层通过setter方法给属性赋值
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Integer getNums() {
		return nums;
	}
	public void setNums(Integer nums) {
		this.nums = nums;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Integer getDiningTableId() {
		return diningTableId;
	}
	public void setDiningTableId(Integer diningTableId) {
		this.diningTableId = diningTableId;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

	@Override
	public String toString() {
		return  id +
				"\t" + menuId + 
				"\t" + nums + 
				"\t" + money +
				"\t" + diningTableId  +
				"\t" + billDate + 
				"\t" + state +
				"\t" + name +
				"\t" + price;
	}	


}
