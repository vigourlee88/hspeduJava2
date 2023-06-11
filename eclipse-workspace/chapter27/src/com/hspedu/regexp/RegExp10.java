package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//正则表达式 的应用实例 对字符串进行如下验证
public class RegExp10 {
	public static void main(String[] args) {
		//String content = "韩顺平a教育";
		String content = "13588889999";
		
		//汉字  ^开始，$结尾，[]范围 ，+ 至少有一个
		//String regStr = "^[\u0391-\uffe5]+$";
		
		//邮政编码
		//要求 是1-9开头的一个六位数，比如123890
		//开头[1-9]，结尾\\d{5} 5个数
		//String regStr = "^[1-9]\\d{5}$";
		
		//QQ号码  
		//VT要求 是1-9开头的一个(5-10位数)
		//String regStr = "^[1-9]\\d{4,9}$";
		
		//手机号码
		//要求 必须以13,14,15,18开头的11位数
		String regStr = "^1[3|4|5|8]\\d{9}$";
		
		Pattern pattern = Pattern.compile(regStr);
		Matcher matcher = pattern.matcher(content);
		
		if(matcher.find()) {
			System.out.println("满足格式");
		}else {
			System.out.println("不满足格式");
		}
	}

}
