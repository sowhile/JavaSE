package learn.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/20 11:39
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10531);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server!".getBytes());
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        int readLen;
        byte[] bytes = new byte[1024];
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.print(new String(bytes, 0, readLen));
        }
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
