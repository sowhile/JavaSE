package learn.file_.objectoutput;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/18 10:11
 */
public class out {
    public static void main(String[] args) throws IOException {
        File file = new File("c:\\io\\test.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeInt(1);
        objectOutputStream.writeUTF("hello,world");
        objectOutputStream.writeObject(new Dog("doge", 1));
        objectOutputStream.close();
    }
}
