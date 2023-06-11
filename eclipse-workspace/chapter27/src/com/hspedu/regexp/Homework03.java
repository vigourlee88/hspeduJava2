package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework03 {
	public static void main(String[] args) {
		
		 //String content = "https://www.sohu.com:8080/abc/index.html";
		 String content = "http://www.sohu.com:8080/abc/xxx/yyy/////inde@#$%x.html";

           //因为正则表达式是根据要求来编写的，
	       //所以，如果需求需要的话，可以改进.
		   //思路: 分组 分4组 分别获取到对应的值
		   //String regStr = "^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)[\\w-/]*/([\\w.]+)$";
		   //因为正则表达式是根据要求来编写的，所以 如果需求需要的话，可以改进
		   String regStr = "^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)[\\w-/]*/([\\w.@#$%]+)$";
		   
		   Pattern pattern = Pattern.compile(regStr);
		   Matcher matcher = pattern.matcher(content);
		  
		   if(matcher.find()) {//整体匹配，如果匹配成功，可以通过group(x),获取到对应分组的内容
			   System.out.println("整体匹配=" + matcher.group(0));
			   System.out.println("协议是 " + matcher.group(1));
			   System.out.println("域名是 "+ matcher.group(2));
			   System.out.println("端口是 "+ matcher.group(3));
			   System.out.println("文件名是 "+ matcher.group(4));
		   }else {
			   System.out.println("没有匹配成功");
		   }      
    }

}
