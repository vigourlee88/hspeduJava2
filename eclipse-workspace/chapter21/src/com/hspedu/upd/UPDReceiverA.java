package com.hspedu.upd;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//UDP接收端
public class UPDReceiverA {
	public static void main(String[] args) throws IOException {
		//1.创建一个DatagramSocket对象，准备在9999接收数据
		DatagramSocket socket = new DatagramSocket(9999);
		//2.创建一个DatagramPacket 对象，准备接收数据
		// 在前面讲解UDP协议时，一个数据包最大64k
		byte[] buf = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buf,buf.length);
		//3.调用 接收方法，将通过网络传输的DatagramPacket对象
		// 填充到 packet对象中去
		// 当有数据包发送到 本机的9999端口时，就会接收到数据
		// 如果没有数据包发送到 本机9999端口，就会阻塞等待
		System.out.println("接收端A 等待接收数据..");
		socket.receive(packet);
		
		//4.可以把packet 进行拆包，取出数据，并显示
		int length = packet.getLength();//实际接收到的数据长度
		byte[] data = packet.getData();//接收到数据
		
		String s = new String(data,0,length);
		System.out.println(s);
		
		//===恢复信息给B端
		//将需要发送的数据，封装到DatagramPacket对象
		data = "好的，明天见".getBytes();
		
		//说明:封装到DatagramPacket对象 data内存字节数组，data.length,主机(iP),端口回送
		packet = 
				  new DatagramPacket(data,data.length,InetAddress.getByName("192.168.12.1"),9998);
		
		socket.send(packet);//发送
		
		//5.关闭资源
		socket.close();
		System.out.println("A端退出...");
	}

}
