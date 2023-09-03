package cn.itcast.mp.handler;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler  {

	/**
	 * 插入数据时填充
	 */
	@Override
	public void insertFill(MetaObject metaObject) {
		//先获取到password的值,再进行判断,如果为空,就进行填充
		Object password = getFieldValByName("password",metaObject);
		if(null == password) {
			setFieldValByName("password","888888",metaObject);
			
		}
		
	}

	/**
	 * 更新数据时填充
	 */
	@Override
	public void updateFill(MetaObject metaObject) {
	
	}

}
