package learn.file_;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/18 13:31
 */
public class print {

    @Test
    public void output() {
        PrintStream printStream = new PrintStream(System.out);
        printStream.print("D");
    }

    @Test
    public void output2() {
    }
}
