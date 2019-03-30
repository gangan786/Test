package com.meizhuo.DesignPatterns.ConcurrencyDP_4_承诺;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_4_承若
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/30 10:44
 * @UpdateUser:
 * @UpdateDate: 2019/3/30 10:44
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class FTPClientUtil implements FTPUploader {

    final FTPClient ftp = new FTPClient();
    final Map<String, Boolean> dirCreateMap = new HashMap<>();


    @Override
    public void init(String ftpServer, String ftpUserName,
                     String password, String serverDir) throws Exception {
        FTPClientConfig config = new FTPClientConfig();
        ftp.configure(config);

        int reply;
        ftp.connect(ftpServer);

        System.out.println(ftp.getReplyString());

        reply = ftp.getReplyCode();


        //验证连接性
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new RuntimeException("FTP server refused connection.");
        }
        //登录
        boolean isOK = ftp.login(ftpUserName, password);
        if (isOK) {
            System.out.println(ftp.getReplyString());

        } else {
            throw new RuntimeException(
                    "Failed to login." + ftp.getReplyString());
        }

        reply = ftp.cwd(serverDir);
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new RuntimeException(
                    "Failed to change working directory.reply:"
                            + reply);
        } else {

            System.out.println(ftp.getReplyString());
        }

        //指定传输类型
        ftp.setFileType(FTP.ASCII_FILE_TYPE);
    }

    @Override
    public void upload(File file) throws Exception {
        InputStream dataIn =
                new BufferedInputStream(new FileInputStream(file),
                        1024 * 8);
        boolean isOK;
        String dirName = file.getParentFile().getName();
        String fileName = dirName + '/' + file.getName();
        ByteArrayInputStream checkFileInputStream =
                new ByteArrayInputStream(
                        "".getBytes());

        try {
            if (!dirCreateMap.containsKey(dirName)) {
                ftp.makeDirectory(dirName);
                dirCreateMap.put(dirName, null);
            }

            try {
                isOK = ftp.storeFile(fileName, dataIn);
            } catch (IOException e) {
                throw new RuntimeException("Failed to upload " + file, e);
            }

            //搞不懂上传这个空文件有什么用
            if (isOK) {
                ftp.storeFile(fileName + ".c", checkFileInputStream);

            } else {

                throw new RuntimeException(
                        "Failed to upload " + file + ",reply:"
                                + ftp.getReplyString());
            }
        } finally {
            dataIn.close();
        }
    }

    @Override
    public void disconnect() {

    }
}
