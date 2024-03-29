package cn.itcast.mp.injectors;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;


public class MySqlInjector extends DefaultSqlInjector{

	@Override
	public List<AbstractMethod> getMethodList() {
		List<AbstractMethod> list = new ArrayList<>();
		
		//获取父类AbstractSqlInjector的集合
		list.addAll(super.getMethodList());
		
		//再扩充自定义的方法
		list.add(new FindAll());
		
		
		return list;
	}
	
	

}
