package com.itheima.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//lombok 一个Java类库，提供了一组注解，简化POPJ实体类开发
//@Setter
//@Getter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
@Data

public class User {
	private Long id;
	private String name;
	private String password;
	private Integer age;
	private String tel;
		

}
