package learn.net.TCPfilecopy1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.file.Files;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/20 15:14
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        File file = new File("c:\\io\\io.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(file.toPath()));
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytes);
        socket.shutdownOutput();

        BufferedInputStream bufferedInputStream1 = new BufferedInputStream(socket.getInputStream());
        System.out.println(StreamUtils.streamToString(bufferedInputStream1));

        bufferedInputStream1.close();
        outputStream.close();
        bufferedInputStream.close();
        socket.close();
    }
}
