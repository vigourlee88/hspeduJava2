package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//演示限定符的使用
public class RegExp05 {
	public static void main(String[] args) {
		String content = "a211111aaaahello";
		//a{3},1{4},(\\d){2}
		//String regStr = "a{3}";//表示匹配aaa
		//String regStr = "1{4}";//表示匹配1111
		//String regStr = "(\\d){2}";//表示匹配2位任意的数字
		
		//a{3,4},1{4,5},\\d{2,5}
		//细节 JAVA匹配默认贪婪匹配，即尽可能匹配多的
		//String regStr = "a{3,4}";//表示匹配aaa或aaaa
		//String regStr = "1{4,5}";//表示匹配1111或11111
		//String regStr = "\\d{2,5}";//表示匹配2为数字或5位
		
		//1+
		//String regStr = "1+";//匹配一个1或多个1
		//String regStr = "\\d+";//匹配一个数字或多个数字
		
		//1*
		//String regStr = "1*";//匹配0个1或者多个1
		
		//演示?的使用
		String regStr = "a1?";//匹配a或a1
		Pattern pattern = Pattern.compile(regStr);
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find()) {
			System.out.println("找到 "+ matcher.group(0));
		}
	}

}
