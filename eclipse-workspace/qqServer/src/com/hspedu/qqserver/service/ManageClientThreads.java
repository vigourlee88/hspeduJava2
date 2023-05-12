package com.hspedu.qqserver.service;

import java.util.HashMap;
import java.util.Iterator;

//该类用于管理和客户端通信的线程
public class ManageClientThreads {
	private static HashMap<String,ServerConnectClientThread> hm = new HashMap<>();
	
	//返回 hm
	public static HashMap<String, ServerConnectClientThread> getHm() {
		return hm;
	}
	public static void setHm(HashMap<String, ServerConnectClientThread> hm) {
		ManageClientThreads.hm = hm;
	}
	//添加线程对象到 hm集合
	public static void addClientThread(String userId,ServerConnectClientThread serverConnectClientThread) {
		
		hm.put(userId, serverConnectClientThread);
		
	}
	//根据userId返回该id对应的和客户端通信的ServerConnectClientThread线程
	public static ServerConnectClientThread getServerConnectClientThread(String userId) {
		return hm.get(userId);
	}
	
	//增加一个方法，从集合中，删除掉某个线程对象
	public static void removeServerConnectClientThread(String userId) {
		hm.remove(userId);
	}
	
	//编写方法，可以返回在线用户列表
	public static String getOnlineUser() {
		//集合遍历，遍历HashMap的key(即userId)
		Iterator<String> iterator = hm.keySet().iterator();
		String onlineUserList = "";
		while(iterator.hasNext()) {
			onlineUserList += iterator.next().toString() + " " ;
		}
		return onlineUserList;
	}

}
