package learn.net.exercises;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 文件下载
 * 2022/11/20 22:39
 */
public class ex03 {
    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        //接收文件名
        String fileName = "";
        int readLen;
        byte[] bytes = new byte[1024];
        while ((readLen = inputStream.read(bytes)) != -1) {
            fileName = fileName.concat(new String(bytes, 0, readLen));
        }

        File file = getFile(new File("c:\\io"), fileName);
        //设置默认发送文件
        file = file == null ? new File("c:\\io\\test.zip") : file;

        //发送文件
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        int fileReadLen;
        byte[] fileBytes = new byte[4096];
        while ((fileReadLen = fileInputStream.read(fileBytes)) != -1) {
            outputStream.write(fileBytes, 0, fileReadLen);
        }
        socket.shutdownOutput();

        fileInputStream.close();
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }

    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8888);
        //发送文件名
        String fileName = "io.jpg";
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(fileName.getBytes());
        socket.shutdownOutput();

        //接收文件
        File file = new File("src/learn/net/exercises", fileName);
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        int readLen;
        byte[] bytes = new byte[4096];
        while ((readLen = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, readLen);
        }

        fileOutputStream.close();
        inputStream.close();
        outputStream.close();
        socket.close();
    }

    public static File getFile(File file, String fileName) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile())
                if (file1.getName().equals(fileName))
                    return file1;
        }
        return null;
    }
}
