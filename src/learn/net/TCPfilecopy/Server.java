package learn.net.TCPfilecopy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/20 15:14
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        File file = new File("src/learn/net/TCPfilecopy/test.zip");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(file.toPath()));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());

        int readLen;
        byte[] bytes = new byte[8192];
        while ((readLen = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, readLen);
        }

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("received.".getBytes());

        socket.shutdownOutput();
        outputStream.close();
        bufferedInputStream.close();
        bufferedOutputStream.close();
        socket.close();
        serverSocket.close();
    }
}
