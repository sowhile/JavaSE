package learn.net;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/20 10:44
 */
public class InetAPI {
    @Test
    public void t() throws Exception {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress);
        InetAddress inetAddress1=InetAddress.getByName("Surface_wd");
        System.out.println(inetAddress1);
        InetAddress inetAddress2=InetAddress.getByName("no996.cloud");
        System.out.println(inetAddress2.getHostName());
        System.out.println(InetAddress.getByName("www.tencent.com").getHostAddress());
    }
}
