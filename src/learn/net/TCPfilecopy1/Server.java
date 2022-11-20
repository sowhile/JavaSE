package learn.net.TCPfilecopy1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
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
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        File file = new File("src/learn/net/TCPfilecopy1/io.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(file.toPath()));
        bufferedOutputStream.write(bytes);

        BufferedOutputStream bufferedOutputStream1 = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream1.write("received".getBytes());

        bufferedOutputStream1.close();
        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();
    }
}
