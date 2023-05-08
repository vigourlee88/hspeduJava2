package com.hspedu.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//文件上传的服务端
public class TCPFileUploadServer {
	public static void main(String[] args) throws Exception {
		
		//1.服务端在本机，监听8888端口
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("服务端在8888端口监听....");
		//2.等待连接
		Socket socket = serverSocket.accept();
		
		//3.读取客户端发送的数据
		//通过Socket得到输入流
		InputStream inputStream = socket.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		byte[] bytes = StreamUtils.streamToByteArray(bis);
		//4.将得到的bytes 数组，写入到指定的路径，就得到一个文件了
		//String destFilePath = "src\\qie2.png";
		String destFilePath = "d:\\无名.mp3";
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
		bos.write(bytes);
		bos.close();
		
		//向客户端回复"收到图片"
		//通过socket获取到输出流
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		writer.write("收到图片");
		writer.flush();//把内容刷新到数据通道
		socket.shutdownOutput();//设置写入结束标记
		
		//关闭其他资源
		writer.close();
		bis.close();
		socket.close();
		serverSocket.close();
	}
}
