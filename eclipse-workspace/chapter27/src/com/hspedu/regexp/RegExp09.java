package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//非贪婪匹配
public class RegExp09 {
	public static void main(String[] args) {
		String content = "hello111111 ok";
		//String regStr = "\\d+";//匹配1到多个 数字，默认是贪婪匹配
		String regStr = "\\d+?";//默认是 非 贪婪匹配
		
		Pattern pattern = Pattern.compile(regStr);
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find()) {
			System.out.println("找到 " + matcher.group(0));
		}
	}

}
