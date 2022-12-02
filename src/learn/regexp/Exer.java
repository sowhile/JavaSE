package learn.regexp;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sowhile
 * <p>
 * 2022/12/2 9:54
 */
public class Exer {
    @Test
    public void ex01() {
        String content = "edr_2ecf234@qq.tinguh.com.";
        String regStr = "^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }

    @Test
    public void ex02() {
        String content = "-0.89";
        String regStr = "^[+-]?(([1-9]\\d*)|0)(\\.\\d*)?$";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }

    @Test
    public void ex03() {
        String content = "http://www.souhu.com:8080/abc/index.html";
        String regStr = "^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)[\\w/-]*/([\\w.]+)$";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
        }
    }
}
