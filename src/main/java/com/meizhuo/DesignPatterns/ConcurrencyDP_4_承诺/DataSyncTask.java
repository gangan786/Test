package com.meizhuo.DesignPatterns.ConcurrencyDP_4_承诺;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_4_承若
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/30 10:40
 * @UpdateUser:
 * @UpdateDate: 2019/3/30 10:40
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class DataSyncTask implements Runnable {

    private final Map<String, String> taskParameters;

    public DataSyncTask(Map<String, String> taskParameters) {
        this.taskParameters = taskParameters;
    }

    @Override
    public void run() {

        String ftpServer = taskParameters.get("server");
        String ftpUserName = taskParameters.get("userName");
        String password = taskParameters.get("password");
        String serverDir = taskParameters.get("serverDir");

        // init ThreadPool
        //部不建议直接使用Executors直接创建线程池
        ExecutorService service = Executors.newSingleThreadExecutor();
        //init FTP client
        Future<FTPUploader> future = FTPUploaderPromisor.newFTPUploaderPromise(ftpServer, ftpUserName, password, serverDir, service);
        //查询数据库生成本地文件
        generateFilesFromDB();

        FTPUploader ftpUploader = null;
        try {
            ftpUploader = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //upload file
        uploadFiles(ftpUploader);


    }

    private void uploadFiles(FTPUploader ftpClientUtil) {
        Set<File> files = retrieveGeneratedFiles();
        for (File file : files) {
            try {
                ftpClientUtil.upload(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    protected Set<File> retrieveGeneratedFiles() {
        Set<File> files = new HashSet<File>();

        // 模拟生成本地文件
        // 省略其他代码
        return files;
    }

    /**
     * 模拟从数据库中取出数据
     */
    private void generateFilesFromDB() {

    }
}
