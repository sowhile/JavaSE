package learn.net.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/20 21:30
 */
public class UDPSender {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(60532);
        byte[] send;
        DatagramPacket datagramPacket = new DatagramPacket(send = "hello,receiver!".getBytes(),
                0, send.length, InetAddress.getByName("127.0.0.1"), 60531);
        datagramSocket.send(datagramPacket);

        byte[] receive = new byte[64 * 1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(receive, receive.length);
        datagramSocket.receive(datagramPacket1);
        System.out.println(new String(receive, 0, datagramPacket1.getLength()));
        datagramSocket.close();
    }
}
