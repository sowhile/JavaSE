package learn.net.exercises;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/20 22:28
 */
public class ex02 {

    @Test
    public void receiverA() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        byte[] send;
        DatagramPacket datagramPacket1 = new DatagramPacket(send = "What?".getBytes(),
                send.length, InetAddress.getByName("127.0.0.1"), 8889);
        datagramSocket.send(datagramPacket1);

        byte[] receive = new byte[64 * 1024];
        DatagramPacket datagramPacket = new DatagramPacket(receive, 0, receive.length);
        datagramSocket.receive(datagramPacket);

        System.out.println(new String(receive, 0, datagramPacket.getLength()));
        datagramSocket.close();
    }

    @Test
    public void senderB() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8889);

        byte[] receive = new byte[64 * 1024];
        DatagramPacket datagramPacket = new DatagramPacket(receive, 0, receive.length);
        datagramSocket.receive(datagramPacket);
        String strReceive = new String(receive, 0, datagramPacket.getLength());
        String strSend;
        if (strReceive.equals("What?")) strSend = "红楼梦，三国演义，西游记，水浒传";
        else strSend = "重说。";
        byte[] send;
        DatagramPacket datagramPacket1 = new DatagramPacket(send = strSend.getBytes(),
                send.length, InetAddress.getByName("127.0.0.1"), 8888);
        datagramSocket.send(datagramPacket1);
        datagramSocket.close();
    }
}
