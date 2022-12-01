package learn.regexp;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sowhile
 * <p>
 * 2022/12/1 17:34
 */
public class Experience {
    @Test
    public void mey1() {
        String content = "123rabc";
        String regStr = "^[0-9]+[a-z]+$";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find())
            System.out.println("结果:" + matcher.group(0));
    }
}
