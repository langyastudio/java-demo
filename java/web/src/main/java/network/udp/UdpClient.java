package network.udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        ds.setSoTimeout(1000);
        ds.connect(InetAddress.getByName("localhost"), 1234);

        byte [] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        //发送数据
        System.out.println("send your data");
        Scanner scanner = new Scanner(System.in);
        for (;;){
            //发送数据
            String s = scanner.nextLine();
            packet.setData(s.getBytes());
            ds.send(packet);

            //接收数据
            DatagramPacket packetRec = new DatagramPacket(buffer, buffer.length);
            ds.receive(packetRec);
            System.out.println(new String(packetRec.getData(), packetRec.getOffset(), packetRec.getLength()));
        }
    }
}
