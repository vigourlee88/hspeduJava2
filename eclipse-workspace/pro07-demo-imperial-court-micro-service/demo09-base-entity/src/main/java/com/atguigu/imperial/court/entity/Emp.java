package com.atguigu.imperial.court.entity;

import java.io.Serializable;

import javax.persistence.Table;

@Table(name = "t_emp")
public class Emp implements Serializable {// 要涉及到网络传输，要实现序列化接口Serializable

	private Integer empId;

	private String empName;

	private String empPosition;

	private String loginAccount;

	private String loginPassword;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName == null ? null : empName.trim();
	}

	public String getEmpPosition() {
		return empPosition;
	}

	public void setEmpPosition(String empPosition) {
		this.empPosition = empPosition == null ? null : empPosition.trim();
	}

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount == null ? null : loginAccount.trim();
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword == null ? null : loginPassword.trim();
	}
}
