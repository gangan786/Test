package com.meizhuo.DesignPatterns.ConcurrencyDP_4_承诺;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_4_承诺
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/30 14:11
 * @UpdateUser:
 * @UpdateDate: 2019/3/30 14:11
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {
    public static void main(String[] args) {
        Map<String, String> params = new HashMap<String, String>();

        // FTP服务器IP地址，运行代码时请根据实际情况修改！
        params.put("server", "10.0.0.5");

        // FTP账户名，运行代码时请根据实际情况修改！
        params.put("userName", "datacenter");

        // FTP账户密码，运行代码时请根据实际情况修改！
        params.put("password", "abc123");

        // FTP服务器基准目录！
        params.put("serverDir", "~/subspsync");

        // 如果要使用真实的FTP服务器，请将下面的这条语句注释掉
//        System.setProperty("ftp.client.impl",
//                "com.meizhuo.DesignPatterns.ConcurrencyDP_4_承诺.FTPUploaderPromisor");

        DataSyncTask dst;
        dst = new DataSyncTask(params);
        Thread t = new Thread(dst);
        t.start();
    }
}
