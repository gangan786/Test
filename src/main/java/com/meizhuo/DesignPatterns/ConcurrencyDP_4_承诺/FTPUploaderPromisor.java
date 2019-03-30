package com.meizhuo.DesignPatterns.ConcurrencyDP_4_承诺;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_4_承若
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/30 12:04
 * @UpdateUser:
 * @UpdateDate: 2019/3/30 12:04
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class FTPUploaderPromisor {

    public static Future<FTPUploader> newFTPUploaderPromise(String ftpServer,
                                                            String ftpUserName,
                                                            String password,
                                                            String serverDir) {
        Executor helperExecutor = new Executor() {
            @Override
            public void execute(Runnable command) {
                Thread thread = new Thread(command);
                thread.start();
            }
        };

        return newFTPUploaderPromise(ftpServer, ftpUserName, password, serverDir, helperExecutor);
    }

    public static Future<FTPUploader> newFTPUploaderPromise(String ftpServer, String ftpUserName,
                                                             String password, String serverDir,
                                                             Executor helperExecutor) {
        Callable<FTPUploader> callable = new Callable<FTPUploader>() {
            @Override
            public FTPUploader call() throws Exception {
                String implClazz = System.getProperty("ftp.client.impl");
                // 类FTPClientUtil的源码参见本书配套下载
                if (null == implClazz) {
                    implClazz =
                            "com.meizhuo.DesignPatterns.ConcurrencyDP_4_承诺.FTPClientUtil";
                }
                FTPUploader ftpUploader;
                ftpUploader = (FTPUploader) Class.forName(implClazz).newInstance();
                ftpUploader.init(ftpServer, ftpUserName, password, serverDir);
                return ftpUploader;
            }
        };

        final FutureTask<FTPUploader> task = new FutureTask<>(callable);
        //交由线程执行连接FTP服务器
        helperExecutor.execute(task);

        return task;
    }

}
