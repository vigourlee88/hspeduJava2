package com.mhl.service;

import java.util.List;

import com.mhl.dao.MenuDAO;
import com.mhl.domain.Menu;

//完成对Menu表的各种操作(通过调用MenuDAO)
public class MenuService {
	//定义MennuDAO属性
	private MenuDAO menuDAO = new MenuDAO();

	//返回所有的菜品，返回给界面使用
	public List<Menu> list(){
		return menuDAO.queryMulti("select * from menu",Menu.class);
		
	}
	
	//需要方法，根据id返回Menu对象
	public Menu getMenuById(int id) {
		return menuDAO.querySingle("select * from menu where id = ?",Menu.class,id);
		
	}
}
