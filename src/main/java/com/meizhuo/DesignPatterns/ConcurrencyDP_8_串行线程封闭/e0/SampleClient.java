package com.meizhuo.DesignPatterns.ConcurrencyDP_8_串行线程封闭.e0;

import org.junit.Test;

/**
 * @Classname SampleClient
 * @Description 简单下载客户端
 * @Date 2019/6/6 11:54
 * @Created by Gangan
 */
public class SampleClient {

    /**
     * 这个变量的使用场景
     * 是设想在有多个线程的共享此变量
     * 并尽心下载操作
     */
    private static final MessageFileDownloader DOWNLOADER;

    static {
        MessageFileDownloader mfd = null;
        try {
            mfd = new MessageFileDownloader("D:\\Users\\mr.gan\\WebProject" +
                    "\\Test\\src\\main\\java\\com\\meizhuo\\DesignPatterns" +
                    "\\ConcurrencyDP_8_串行线程封闭\\e0", "192.168.25.135",
                    "ftp", "chengan1997",
                    "/pub");
        } catch (Exception e) {
            e.printStackTrace();
        }
        DOWNLOADER = mfd;
    }

    @Test
    public void testFTPServer() throws InterruptedException {


        //添加下载文件
        DOWNLOADER.downloadFile("Gangan.xml");
        DOWNLOADER.downloadFile("Dondong.xml");
        //启动下载
        DOWNLOADER.init();
        Thread.sleep(5*1000);
        DOWNLOADER.shutdown();
    }

}
