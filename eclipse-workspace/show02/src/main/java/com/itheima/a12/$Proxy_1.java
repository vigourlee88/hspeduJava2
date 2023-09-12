package com.itheima.a12;


import java.lang.reflect.Method;

import com.itheima.a12.A12_1.Foo;
import com.itheima.a12.A12_1.InvocationHandler;

public class $Proxy_1 implements Foo{
	private InvocationHandler h;//设置类回调invoke操作

	public $Proxy_1(InvocationHandler h) {
		this.h = h;
	}
	
	@Override
	public void foo() {
		try {
			Method foo = Foo.class.getMethod("foo");
			h.invoke(foo, new Object[0]);
		
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void bar() {
		try {
			Method bar = Foo.class.getMethod("bar");
			h.invoke(bar, new Object[0]);
		
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
