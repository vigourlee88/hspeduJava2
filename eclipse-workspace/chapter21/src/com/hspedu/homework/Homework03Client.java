package com.hspedu.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

//文件下载的客户端
public class Homework03Client {
	public static void main(String[] args) throws Exception {
		
	//1.接收用户输入，指定下载文件名
	Scanner scanner = new Scanner(System.in);
	System.out.println("请输入下载文件名");
	String downLoadFileName = scanner.next();
	
	//2.客户端连接服务端，准备发送
	Socket socket = new Socket(InetAddress.getLocalHost(),9999);
	//3.获取和Socket关联的输出流
	OutputStream outputStream = socket.getOutputStream();
	outputStream.write(downLoadFileName.getBytes());
	//设置写入结束的标志
	socket.shutdownOutput();
	
	//4.读取服务端返回的文件(字节数据)
	BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
	byte[] bytes = StreamUtils.streamToByteArray(bis);
	//5.得到一个输出流，准备将bytes写入到磁盘文件		
	//比如你下载的是高山流水，下载的就是高山流水.mp3
	//你下载的是韩顺平，下载的就是无名.mp3 文件名韩顺平
	String filePath = "d:\\"+ downLoadFileName + ".mp3";
	BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
	bos.write(bytes);
	
	//6.关闭相关资源
	bos.close();
	bis.close();
	outputStream.close();
	socket.close();
	
	System.out.println("客户端下载完毕，正确退出...");
	
	}
}
