package com.hspedu.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

//演示InetAddress类的使用
public class API_ {
	public static void main(String[] args) throws UnknownHostException {
		
		//1.获取本机的InetAddress对象
		InetAddress localHost = InetAddress.getLocalHost();
		System.out.println(localHost);//DESKTOP-EIJ28B0/192.168.32.228
		
		//2.根据指定主机名 获取InetAddress对象
		InetAddress host1 = InetAddress.getByName("DESKTOP-EIJ28B0");
		System.out.println("host1=" + host1);//DESKTOP-EIJ28B0/192.168.32.228
		
		//3.根据域名返回InetAddress对象，比如www.baidu.com对应
		InetAddress host2 = InetAddress.getByName("www.baidu.com");
		System.out.println("host2=" + host2);//www.baidu.com/192.168.32.228
		
		//4.通过InetAddress 对象 获取对应的地址
		String hostAddress = host2.getHostAddress();// 192.168.32.228
		System.out.println("host2 对应的ip = " + hostAddress);//192.168.32.228
		
		//5.通过 InetAddress 对象，获取对应的主机名或者域名
		String hostName = host2.getHostName();
		System.out.println("host2对应的主机名/域名=" + hostName);//www.baidu.com
	}

}
