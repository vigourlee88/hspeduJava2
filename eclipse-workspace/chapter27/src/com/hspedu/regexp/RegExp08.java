package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//演示非捕获分组，语法比较
public class RegExp08 {
	public static void main(String[] args) {
		
		String content = "hello韩顺平教育 jack韩顺平老师 韩顺平同学hello韩顺平";
		
		//找到 韩顺平教育，韩顺平老师，韩顺平同学 子字符串
		//String regStr = "韩顺平教育|韩顺平老师|韩顺平同学";
		//上面可以等价 非捕获分组 注意: 不能 matcher.group(1)
		//String regStr = "韩顺平(?:教育|老师|同学)";
		
		//找到韩顺平这个关键字，但是要求
		//只是查找韩顺平教育和韩顺平老师中 含有的韩顺平
		//String regStr = "韩顺平(?=教育|老师)";
		
		////找到韩顺平这个关键字，但是要求
		//只是查找不是 (韩顺平教育和韩顺平老师)中 含有的韩顺平
		String regStr = "韩顺平(?!教育|老师)";
		
		Pattern pattern = Pattern.compile(regStr);
		Matcher matcher = pattern.matcher(content);
		
		while(matcher.find()) {
			System.out.println("找到 " + matcher.group(0));
		}
	}
}
