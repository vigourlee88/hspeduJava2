package com.ithiema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.ithiema.bean.CartoonCatAndMouse;

@SpringBootApplication
@Import(CartoonCatAndMouse.class)
public class App { // bean依赖属性配置
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
		CartoonCatAndMouse bean = ctx.getBean(CartoonCatAndMouse.class);
		bean.play();
	}
}
