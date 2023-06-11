package com.hspedu.regexp;

public class Homework02 {
	public static void main(String[] args) {
		//要求验证是不是整数或者小数
		//提示这个题要考虑 正数和负数
		//123 -345 34.89 -87.9 -0.01 0.45等
		
		/*
		 * 思路
		 * 1.先写出简单的正则表达式
		 * 2.在逐步的完善  根据各种情况来完成
		 */
		//String content = "123";
		//String regStr = "^\\d+$";//^$定位->是不是数字
		
		//String content = "+123";
		//String regStr = "^[-+]?\\d+$";//?可能有或没有
		
		//String content = "34.89";
		//String regStr = "^[-+]?\\d+(\\.\\d+)?$";// (\\.\\d+)? ->.任意数字
		
		String content = "-0.3489";
		String regStr = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";
		
		if(content.matches(regStr)) {
			System.out.println("匹配成功，是整数或者小数");
		}else {
			System.out.println("匹配失败");
		}
	}

}
