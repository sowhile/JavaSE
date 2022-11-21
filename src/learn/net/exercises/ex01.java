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
 * 字节流
 * 2022/11/20 21:54
 */
public class ex01 {

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String receive = bufferedReader.readLine();

        String send;
        if (receive.equals("name")) send = "I'm sowhile.";
        else if (receive.equals("hobby")) send = "java";
        else send = "What are you saying?";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream(), "utf-8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(send);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }

    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8888);
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("hobby");
        bufferedWriter.newLine();
        bufferedWriter.flush();//必须使用flush()

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream(), "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println(bufferedReader.readLine());

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
    }
}
