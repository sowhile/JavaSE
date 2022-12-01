package learn.regexp;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sowhile
 * <p>
 * 2022/12/1 22:43
 */
public class ApplicationExample {
    //判断是否全为汉字
    @Test
    public void met1() {
        String content = "山地车是a非重返";
        String regStr = "^[\u0391-\uffe5]+$";

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()) System.out.println("success");
        else System.out.println("fail");
    }

    //验证邮政编码，要求是 1-9 开头的一个 6 位数
    @Test
    public void met2() {
        String content = "710054";
        String regStr = "^[1-9]\\d{5}$";

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()) System.out.println("success");
        else System.out.println("fail");
    }

    //验证QQ号 要求 1-9 开头的 5-10 位数
    @Test
    public void met3() {
        String content = "76430";
        String regStr = "^[1-9]\\d{4,9}$";

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()) System.out.println("success");
        else System.out.println("fail");
    }

    //验证手机号码，要求 13 14 15 18 开头的 11 位数
    @Test
    public void met4() {
        String content = "13894807091";
        String regStr = "^(?:13|14|15|18)\\d{9}$";

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()) System.out.println("success");
        else System.out.println("fail");
    }

    //验证URL
    @Test
    public void metURL() {
        String content = "https://www.bilibili.com/video/BV1cr4y1c7nZ/?spm_id_from=333.999.0.0&vd_source=bffe9f6043d7ec1cc5da45e0b167c7a5";
        String regStr = "^(http(s)?://)?([\\w-]+\\.)+[\\w~/]+([\\w-~?=#&/%.]*)?$";

        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
//        if (matcher.find()) System.out.println("success");
//        else System.out.println("fail");
    }

    @Test
    public void met6() {
        String content = "192.168.1.1";
        String regStr = "[.]";

//        Pattern compile = Pattern.compile(regStr);
//        Matcher matcher = compile.matcher(content);

        String[] split = content.split(regStr);
        for (String s : split) {
            System.out.print(s + " ");
        }
    }
}
