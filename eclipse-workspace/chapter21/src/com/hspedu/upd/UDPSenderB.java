package com.hspedu.upd;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//UDPSender发送端-->也可以接收数据
public class UDPSenderB {
	public static void main(String[] args) throws IOException {
		//1.创建 DatagramSocket 对象，准备在9998端口 接收数据
		DatagramSocket socket = new DatagramSocket(9998);
		
		//2.将需要发送的数据，封装到DatagramPacket对象
		byte[] data = "hello 明天吃火锅~".getBytes();
		
		//说明: 封装到 DatagramPacket对象 data内容字节数组,data.length,主机(IP)
		DatagramPacket packet = 
				new DatagramPacket(data,data.length,InetAddress.getByName("192.168.12.1"),9999);
		
		socket.send(packet);
		
		//3.===接收从A端回复的信息
		// 3.1创建一个DatagramPacket 对象，准备接收数据
		// 在前面讲解UDP协议时，一个数据包最大64k
		byte[] buf = new byte[1024];
		packet = new DatagramPacket(buf,buf.length);
		// 3.2调用 接收方法，将通过网络传输的DatagramPacket对象
		// 填充到 packet对象中去
		// 当有数据包发送到 本机的9998端口时，就会接收到数据
		// 如果没有数据包发送到 本机9998端口，就会阻塞等待
		socket.receive(packet);
		
		// 3.3可以把packet 进行拆包，取出数据，并显示
		int length = packet.getLength();//实际接收到的数据长度
		data = packet.getData();//接收到数据	
		String s = new String(data,0,length);
		System.out.println(s);
		//关闭资源
		socket.close();
		System.out.println("B端退出...");
	}
}
