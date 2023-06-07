package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//演示字符匹配符 的使用
public class RegExp03 {
	public static void main(String[] args) {
		
		String content = "a11c8abc _AB\nCy@";
		//String regStr = "[a-z]";//匹配 a-z 之间任意一个字符
		//String regStr = "[A-Z]";//匹配 a-z 之间任意一个字符
		//String regStr = "abc";//匹配abc 字符串 [默认区分大小写]
		//String regStr = "(?i)abc";//匹配abc 字符串 [不区分大小写]
		//String regStr = "[0-9]";//匹配0-9 之间任意一个字符
		//String regStr = "[^a-z]";//匹配 不在 a-z 之间任意一个字符
		//String regStr = "[^0-9]";//匹配 不在 0-9 之间任意一个字符
		//String regStr = "[abcd]";//匹配 在 abcd 中任意一个字符
		//String regStr = "\\D";//匹配 不在0-9的任意一个字符
		//String regStr = "\\w";//匹配 大小写英文字母，数字，下划线
		//String regStr = "\\W";//匹配 等价于 [^a-zA-Z0-9]
		//String regStr = "\\s";//匹配 任何空白字符包括 空格，制表符等
		//String regStr = "\\S";
		String regStr = ".";//匹配\n之外的所有字符，如果要匹配，本身则需要使用\\.
		
		
		//[a-z] 去匹配a11c8  会得到什么结果?
		//Pattern pattern = Pattern.compile(regStr);
		//说明
		//1.当创建Pattern对象时，指定Pattern.CASE_INSENSIVE,表示匹配是不区分大小写
		Pattern pattern = Pattern.compile(regStr/*,Pattern.CASE_INSENSITIVE*/);
		Matcher matcher = pattern.matcher(content);//a c
		
		while(matcher.find()) {
			System.out.println("找到 " + matcher.group(0));
		}
		
		
	}

}
