package com.meizhuo.DesignPatterns.ConcurrencyDP_8_串行线程封闭.e0;

import com.meizhuo.DesignPatterns.ConcurrencyDP_3_两阶段终止.AbstractTerminatableThread;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Classname WorkerThread
 * @Description 工作线程
 * @Date 2019/6/6 10:52
 * @Created by Gangan
 */
public class WorkerThread extends AbstractTerminatableThread {

    protected final BlockingQueue<String> workQueue;
    private final FTPClient ftpClient;
    private final String outputDir;
    private String serverWorkDir;

    public WorkerThread(String outputDir, final String ftpServer,
                        final String userName, final String password,
                        String serverWorkDir) throws IOException {
        this.workQueue = new ArrayBlockingQueue<>(100);
        this.outputDir = outputDir + "/";
        this.serverWorkDir=serverWorkDir;
        this.ftpClient = initFTPClient(ftpServer, userName, password);
    }

    /**
     * 放进队列进行下载
     * @param file
     */
    public void download(String file)  {
        try {
            workQueue.put(file);
            terminationToken.reservations.incrementAndGet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接FTP服务
     * 并切换到指定工作目录
     * @param ftpServer
     * @param userName
     * @param password
     * @return
     * @throws IOException
     */
    protected FTPClient initFTPClient(String ftpServer, String userName, String password) throws IOException {
        FTPClient ftpClient = new FTPClient();
        FTPClientConfig ftpClientConfig = new FTPClientConfig();
        ftpClient.configure(ftpClientConfig);

        int reply;
        ftpClient.connect(ftpServer);

        System.out.println(ftpClient.getReplyString());

        reply = ftpClient.getReplyCode();

        if (!FTPReply.isPositiveCompletion(reply)) {
            ftpClient.disconnect();
            throw new RuntimeException("FTP Server Refuse Connection");
        }

        boolean isOk = ftpClient.login(userName, password);

        if (isOk) {
            System.out.println(ftpClient.getReplyString());
        } else {
            throw new RuntimeException("Login Fail!! [message]: "+ftpClient.getReplyString() );
        }

        reply = ftpClient.cwd(serverWorkDir);

        if (!FTPReply.isPositiveCompletion(reply)) {
            ftpClient.disconnect();
            throw new RuntimeException("Fail to change work directory. [reply]: " + reply);
        } else {
            System.out.println(ftpClient.getReplyString());
        }

        ftpClient.setFileType(FTP.ASCII_FILE_TYPE);

        return ftpClient;
    }

    @Override
    protected void doRun() throws Exception {
        String file = workQueue.take();
        boolean isOk;
        try (OutputStream os = new BufferedOutputStream(new FileOutputStream(outputDir + file))) {
            isOk = ftpClient.retrieveFile(file, os);
            if (!isOk) {
                System.err.println("Failed to download");
            }
        }finally {
            //当一个任务执行成功或者失败以后
            //都要将Token的任务记录数减一
            terminationToken.reservations.decrementAndGet();
        }
    }

    @Override
    protected void doCleanup(Exception cause) {
        try {
            ftpClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
