package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//演示正则表达式的使用
public class RegExp11 {
	public static void main(String[] args) {
		
		String content = "https://www.bilibili.com/video/BV1fh411y7R8?p=894&spm_id_from=pageDriver&vd_source=55dcd9ea31c7233f854cca0c4168fdd6";
		
		/*
		 * 分析思路
		 * 1.先确定URL开始的部分http:// | http://
		 *   \\w字符匹配符 0-9|a-zA-Z|_
		 *     https://www.bilibili.com/
		 *    "^((https|http)://)([\\w-]\\.)+[\\w-]+$"
		 *   2.然后通过([\\w-]+\\.)+[\\w-]+ 匹配www.bilibili.com
		 *   3./video/BV1fh411y7R8?from=sear匹配(\\/[\\w-?=&/%.#]*)?
		 *   注意当[.]  表示匹配 .本身
		 */
		String regStr = "^((https|http)://)?([\\w-]+\\.)"
				+ "+[\\w-]+(\\/[\\w-?=&/%.]*)?$";
		
		Pattern pattern = Pattern.compile(regStr);
		Matcher matcher = pattern.matcher(content);
		
		if(matcher.find()) {
			System.out.println("满足格式");
		}else {
			System.out.println("不满足格式");
		}
		
		//这里如果使用Pattern 的matches整体匹配，比较简洁
		System.out.println("整体匹配=" + Pattern.matches(regStr, content));
		
	}
}
