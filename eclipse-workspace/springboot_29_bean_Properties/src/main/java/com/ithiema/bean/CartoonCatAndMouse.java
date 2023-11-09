package com.ithiema.bean;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.util.StringUtils;

import lombok.Data;

//@Component
@Data
@EnableConfigurationProperties(CartoonProperties.class) // 强制哪个类加载成配置类
public class CartoonCatAndMouse {
	private Cat cat;
	private Mouse mouse;

	private CartoonProperties cartoonProperties;

	public CartoonCatAndMouse(CartoonProperties cartoonProperties) {
		this.cartoonProperties = cartoonProperties;
		cat = new Cat();
		cat.setName(cartoonProperties.getCat() != null && StringUtils.hasText(cartoonProperties.getCat().getName())
				? cartoonProperties.getCat().getName()
				: "tom");
		cat.setAge(cartoonProperties.getCat() != null && cartoonProperties.getCat().getAge() != null
				? cartoonProperties.getCat().getAge()
				: 3);
		mouse = new Mouse();
		mouse.setName(
				cartoonProperties.getMouse() != null && StringUtils.hasText(cartoonProperties.getMouse().getName())
						? cartoonProperties.getMouse().getName()
						: "jerry");
		mouse.setAge(cartoonProperties.getMouse() != null && cartoonProperties.getMouse().getAge() != null
				? cartoonProperties.getMouse().getAge()
				: 4);
	}

	public void play() {
//		System.out.println("3岁的tom和4岁的jerry打起来了");
		System.out
				.println(cat.getAge() + "岁的" + cat.getName() + "和" + mouse.getAge() + "岁的" + mouse.getName() + "打起来了");

	}

}
