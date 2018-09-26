package com.meizhuo.CrazyJava.Exception;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExitHook {

    public static void main(String[] args) throws Exception {

        final FileOutputStream fos;
        fos = new FileOutputStream("a.bin");
        System.out.println("程序打开物理资源");
        //为系统注册关闭钩子
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                //使用关闭钩子来关闭资源
                if (fos != null) {
                    try {
                        fos.close();
                        System.out.println("关闭成功");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.exit(0);
    }
}
