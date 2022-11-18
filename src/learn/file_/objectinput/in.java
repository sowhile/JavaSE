package learn.file_.objectinput;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/18 10:18
 */
public class in {
    public static void main(String[] args) throws Exception {
        File file = new File("c:\\io\\test.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readUTF());
        Object o = objectInputStream.readObject();
        System.out.println("o的运行类型=" + o.getClass());
        System.out.println(o);
        objectInputStream.close();
    }
}
