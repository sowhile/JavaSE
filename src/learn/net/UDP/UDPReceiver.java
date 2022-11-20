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
public class UDPReceiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(60531);
        byte[] receive = new byte[64 * 1024];
        DatagramPacket datagramPacket = new DatagramPacket(receive, receive.length);
        datagramSocket.receive(datagramPacket);
        System.out.println(new String(receive, 0, datagramPacket.getLength()));

        byte[] send;
        DatagramPacket datagramPacket1 = new DatagramPacket(send = "hello,sender!".getBytes(),
                0, send.length, InetAddress.getByName("127.0.0.1"), 60532);
        datagramSocket.send(datagramPacket1);
        datagramSocket.close();
    }
}
