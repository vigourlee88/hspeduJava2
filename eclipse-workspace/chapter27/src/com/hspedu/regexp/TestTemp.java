package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestTemp {
	public static void main(String[] args) {
		String content = "hello abc 111.?";
		//String regStr = ".";//匹配除了 \n 的所有字符
		//String regStr = "[.]";//匹配. 本身
		//String regStr = "\\.";//匹配. 本身
		String regStr = "[?]";//匹配?本身
		
		Pattern pattern = Pattern.compile(regStr);
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find()) {
			System.out.println("找到 "+ matcher.group(0));
		
		}
	}

}
