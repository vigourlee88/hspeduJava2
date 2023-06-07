package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//演示转义字符的使用
public class RegExp02 {
	public static void main(String[] args) {
		
		//匹配( => 转义符\\(
		//匹配. => 转义符\\.
		//String regStr = "\\(";
		//String regStr = "\\.";
		//String regStr = "\\d\\d\\d";<=>"\\d{3}"
		String regStr = "\\d{3}";
		
		String content = "abc(abc.123(";
		Pattern pattern = Pattern.compile(regStr);//生成一个正则表达式对象
		Matcher matcher = pattern.matcher(content);//拿到一个匹配器
		
		while(matcher.find()) {
			System.out.println("找到" + matcher.group(0));
		}	
	}
}
