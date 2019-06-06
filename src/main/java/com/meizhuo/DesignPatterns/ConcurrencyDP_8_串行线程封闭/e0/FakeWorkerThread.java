package com.meizhuo.DesignPatterns.ConcurrencyDP_8_串行线程封闭.e0;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

/**
 * @Classname FakeWorkerThread
 * @Description 用于测试的
 *              无实际下载操作的测试类
 * @Date 2019/6/6 11:40
 * @Created by Gangan
 */
public class FakeWorkerThread extends WorkerThread {

    public FakeWorkerThread(String outputDir, String ftpServer,
                            String userName, String password,
                            String serverWorkingDir) throws IOException {
        super(outputDir, ftpServer, userName, password, serverWorkingDir);
    }

    @Override
    protected FTPClient initFTPClient(String ftpServer, String userName,
                                      String password)  {
        FTPClient ftpClient = new FTPClient();
        return ftpClient;
    }

    @Override
    protected void doRun() throws Exception {
        String file = workQueue.take();
        try {
            Thread.sleep(1000);
        } finally {
            terminationToken.reservations.decrementAndGet();
        }

    }

}
