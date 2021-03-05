package network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(1234);

        for (;;){
            //数据缓存区
            byte [] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            //接收数据
            ds.receive(packet);
            String strGet = new String(packet.getData(), packet.getOffset(), packet.getLength());
            System.out.println("receive:" + strGet);

            //发送数据
            packet.setData("success".getBytes());
            ds.send(packet);
        }
    }
}
