package com.mhl.domain;


//Bill 是javaBean 和 bill对应
//id INT PRIMARY KEY AUTO_INCREMENT, #自增主键
//billId VARCHAR(50) NOT NULL DEFAULT '',#账单号可以按照自己规则生成 UUID
//menuId INT NOT NULL DEFAULT 0,#菜品的编号, 也可以使用外键
//nums SMALLINT NOT NULL DEFAULT 0,#份数
//money DOUBLE NOT NULL DEFAULT 0, #金额
//diningTableId INT NOT NULL DEFAULT 0, #餐桌
//billDate DATETIME NOT NULL ,#订单日期
//state VARCHAR(50) NOT NULL DEFAULT '' # 状态 '未结账' , '已经结账', '挂单'
public class Bill {
	private Integer id;
	private String billId;
	private Integer menuId;
	private Integer nums;
	private Double money;
	private Integer diningTableId;
	private String billDate;
	private String state;
	public Bill() {
		super();
	}
	public Bill(Integer id, String billId, Integer menuId, Integer nums, Double money, Integer diningTableId,
			String billDate, String state) {
		super();
		this.id = id;
		this.billId = billId;
		this.menuId = menuId;
		this.nums = nums;
		this.money = money;
		this.diningTableId = diningTableId;
		this.billDate = billDate;
		this.state = state;
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
				"\t" +state ;
	}	

}
