package com.itheima.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
@Data
@NoArgsConstructor
public class Book {
	private Integer id;
	private String type;
	private String name;
	private String description;

}
