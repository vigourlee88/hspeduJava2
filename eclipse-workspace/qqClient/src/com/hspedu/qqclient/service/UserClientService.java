package com.hspedu.qqclient.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.qqcommon.User;

//该类完成用户登录验证和用户注册等功能
public class UserClientService {
	
	//因为我们可能在其他地方要使用user信息，因此做成成员属性
	private User u = new User();
	//因为Socket在其他地方也可能使用，因此做成属性
	private Socket socket;
	
	//根据userId 和 pwd 到服务器验证该用户是否合法
	public boolean checkUser(String userId,String pwd) {
		boolean b = false;
		//创建User对象
		u.setUserId(userId);
		u.setPasswd(pwd);
			
	    try {
	    	//连接到服务器，发送u对象
			//socket = new Socket(InetAddress.getByName("127.0.0.1"),9999);
			socket = new Socket(InetAddress.getLocalHost(),9999);
			//得到ObjectOutputStream对象
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(u);//发送User对象给服务端
			
		    //读取从服务端回复的Message对象
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Message ms = (Message) ois.readObject();
			
			if(ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCESS)) {//登录成功
				
				
				//创建一个和服务器端保持通信的线程，需要创建一个线程类ClientConnectServerThread
				ClientConnectServerThread clientConnectServerThread = 
						new ClientConnectServerThread(socket);
				//启动客户端线程
				clientConnectServerThread.start();
				//为了后面客户端的扩展，我们将线程放入到集合管理
				//静态方法，直接用
				ManageClientConnectServerThread.addClientConnectServerThread(userId,clientConnectServerThread);
				b = true;
				
			}else {
				//如果登录失败，我们就不能启动和服务器通信的线程，关闭socket
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return b;
		
	}
	
	//向服务器端请求在线用户列表
	public void onlineFriendList() {
		//发送一个Message,类型MESSAGE_GET_ONLINE_FRIEND
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
		message.setSender(u.getUserId());
		
		//发送给服务器
		
		try {
			
			//从管理线程集合中，通过userId，得到这个线程
			ClientConnectServerThread clientConnectServerThread = ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId());
			//通过这个线程得到关联的socket
			Socket socket = clientConnectServerThread.getSocket();
			//得到当前线程的Socket对应的ObjectOutputStream对象
			ObjectOutputStream oos = 
					new ObjectOutputStream
					(socket.getOutputStream());
			oos.writeObject(message);//发送一个Message对象，向服务器要求在线用户列表
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//编写方法，退出客户端，并给服务器发送一个退出系统的message对象
	public void logout() {
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
		message.setSender(u.getUserId());//一定要指定我是哪个客户端
		
		//发送message
		try {
			//ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			//通过管理线程的集合，通过ID得到这个线程，再得到它的输出流对象
			ObjectOutputStream oos = 
					new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
			oos.writeObject(message);
			System.out.println(u.getUserId() + " 退出系统");
			System.exit(0);//结束进程
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

}
