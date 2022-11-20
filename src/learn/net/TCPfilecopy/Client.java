package learn.net.TCPfilecopy;

import java.io.*;
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
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        File file = new File("c:\\io\\io.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(file.toPath()));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        int readLen;
        byte[] bytes = new byte[139568];
        while ((readLen = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, readLen);
            bufferedOutputStream.flush();
        }
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        int readLen2;
        byte[] bytes2 = new byte[4096];
        while ((readLen2 = inputStream.read(bytes2)) != -1) {
            System.out.print(new String(bytes2, 0, readLen2));
        }
        inputStream.close();
        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
    }
}
