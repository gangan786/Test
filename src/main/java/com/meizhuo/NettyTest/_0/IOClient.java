package com.meizhuo.NettyTest._0;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/9/26 13:05
 * @UpdateUser:
 * @UpdateDate: 2018/9/26 13:05
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true){
                    socket.getOutputStream().write((new Date() +" : hello word").getBytes());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
