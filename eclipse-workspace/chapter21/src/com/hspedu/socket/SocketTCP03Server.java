package com.hspedu.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketTCP03Server {
	public static void main(String[] args) throws IOException {
		//思路
        //1. 在本机 的9999端口监听, 等待连接
        //   细节: 要求 在本机没有其它服务在监听9999
        //   细节：这个 ServerSocket 可以通过 accept() 返回多个Socket[多个客户端连接服务器的并发]
       ServerSocket serverSocket = new ServerSocket(9999);
       System.out.println("服务端，在9999端口监听，等待连接....");
		
        //2. 当没有客户端连接9999端口时，程序会 阻塞, 等待连接
        //   如果有客户端连接，则会返回Socket对象，程序继续
       Socket socket = serverSocket.accept();
       System.out.println("服务端 socket =" + socket.getClass());

        //3. 通过socket.getInputStream() 读取客户端写入到数据通道的数据, 显示
       InputStream inputStream = socket.getInputStream();
        //4. IO读取，使用字符流，使用转换流将inputStream转成字符流
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
       String s = bufferedReader.readLine();
       System.out.println(s);//输出
       
        //5.获取socket相关联的输出流
       OutputStream outputStream = socket.getOutputStream();
       //使用字符输出流的方式 回复 信息
       BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
       bufferedWriter.write("hello,client 字符流");
       bufferedWriter.newLine();//插入一个换行，表示回复内容的结束
       bufferedWriter.flush();//需要手动刷新
       
       
        //设置结束标记
       socket.shutdownOutput();
        //6.关闭流和socket
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();//关闭

	}
}