package com.meizhuo.DesignPatterns.ConcurrencyDP_8_串行线程封闭.e0;

import com.meizhuo.DesignPatterns.ConcurrencyDP_3_两阶段终止.AbstractTerminatableThread;
import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.*;

/**
 * @Classname MessageFileDownloader
 * @Description 实现FTP文件下载
 * @Date 2019/6/6 10:28
 * @Created by Gangan
 */
public class MessageFileDownloader {

    private final WorkerThread workerThread;

    public MessageFileDownloader(String outputDir, final String ftpServer,
                                 final String userName, final String password,
                                 final String serverWorkingDir) throws IOException {
        Path path = Paths.get(outputDir);
        if (!path.toFile().exists()) {
            Files.createDirectories(path);
        }
        workerThread = new WorkerThread(outputDir, ftpServer, userName, password, serverWorkingDir);
    }

    /**
     * 开始下载
     */
    public void init() {
        workerThread.start();
    }

    /**
     * 关闭下载
     */
    public void shutdown() {
        workerThread.terminate();
    }

    /**
     *
     * 添加下载文件
     * @param file
     */
    public void downloadFile(String file) {
        workerThread.download(file);
    }

}
