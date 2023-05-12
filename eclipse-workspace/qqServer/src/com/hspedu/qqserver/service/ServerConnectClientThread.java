package com.hspedu.qqserver.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

//该类的一个对象和某个客户端保持通信
public class ServerConnectClientThread extends Thread{

	private Socket socket;
	private String userId;//连接到服务端的用户id
	
	public ServerConnectClientThread(Socket socket, String userId) {
		super();
		this.socket = socket;
		this.userId = userId;
	}
	
	public Socket getSocket() {
		return socket;
	}
	
	@Override
	public void run() {//这里线程处于run的状态，可以发送/接收消息
	    
		while(true) {
			try {
				System.out.println("服务端和客户端"+ userId + " 保持通信，读取数据...");
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Message message = (Message) ois.readObject();
				//后面会使用message,根据message的类型，做相应的业务处理
				if(message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
					//客户端要在线用户列表
					/*
					 * 在线用户列表形式 100 200 紫霞仙子
					 */
					System.out.println(message.getSender() + " 要在线用户列表");
					String onlineUser = ManageClientThreads.getOnlineUser();
					//返回message
					//构建一个Message对象，返回给客户端
					Message message2 = new Message();
					message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
					message2.setContent(onlineUser);
					message2.setGetter(message.getSender());
					//写入到数据通道，返回给客户端
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject(message2);
					
				}else if(message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
					//根据message获取getterId,然后得到对应的线程
					ServerConnectClientThread serverConnectClientThread = 
							ManageClientThreads.getServerConnectClientThread(message.getGetter());
					//得到对应的socket的对象输出流，将message对象转发给指定的客户端
					ObjectOutputStream oos = 
							new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
					oos.writeObject(message);//转发，提示如果客户不在线，可以保存到数据库，这样就可以实现离线留言
					
				}else if(message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)) {
					//需要遍历，管理线程的集合，把所有线程的socket都得到，然后把message进行转发即可
					HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();
					
					//遍历
					Iterator<String> iterator = hm.keySet().iterator();
					while(iterator.hasNext()) {
						
						//取出在线用户的id
						String onLineUserId = iterator.next().toString();
						
						if(!onLineUserId.equals(message.getSender())) {//排除 群发消息的这个用户
							//进行转发message
							ObjectOutputStream oos = new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
							oos.writeObject(message);
							
						}
					}
					
				}else if(message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
					//根据getter id 获取到对应的线程，将message对象转发
					ServerConnectClientThread serverConnectClientThread = ManageClientThreads.getServerConnectClientThread(message.getGetter());
					ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
				
				}else if(message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {//客户端退出
					System.out.println(message.getSender() + " 退出");
					//将客户端对应的线程，从集合中移除
					ManageClientThreads.removeServerConnectClientThread(message.getSender());
					socket.close();//关闭连接
					//退出线程
					break;//直接退出while，run()结束，线程就结束了
					
				}
				else {
					System.out.println("其他类型的message,暂时不处理");
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				
			}
		
		}
	}
	
}
