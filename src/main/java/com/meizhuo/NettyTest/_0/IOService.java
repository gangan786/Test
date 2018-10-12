package com.meizhuo.NettyTest._0;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/9/26 12:36
 * @UpdateUser:
 * @UpdateDate: 2018/9/26 12:36
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class IOService {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8000);
        //接收新连接线程
        new Thread(() -> {
            while (true) {
                //阻塞方法获取新的连接
                try {
                    Socket socket = serverSocket.accept();
                    //一旦accept方法获取到socket新连接，那么这个方法将不会被阻塞，
                    // 会执行下面的传线程创建过程
                    new Thread(() -> {
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            //按照字节流方式读取数据
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data, 0, len));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
