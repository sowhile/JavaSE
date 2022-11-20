package learn.net.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/20 11:39
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10531);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        int readLen;
        byte[] bytes = new byte[1024];
        while ((readLen = inputStream.read(bytes)) != -1) {
            System.out.print(new String(bytes, 0, readLen));
        }
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("hello,client!".getBytes());
        accept.shutdownOutput();
        outputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
