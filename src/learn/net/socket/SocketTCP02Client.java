package learn.net.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/20 14:38
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10531);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,server!");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
    }
}
