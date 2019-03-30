package com.meizhuo.DesignPatterns.ConcurrencyDP_4_承诺;

import java.io.File;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_4_承若
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/30 11:21
 * @UpdateUser:
 * @UpdateDate: 2019/3/30 11:21
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public interface FTPUploader {

    /**
     * 初始化连接FTP服务器
     * @param ftpServer
     * @param ftpUserName
     * @param password
     * @param serverDir
     * @throws Exception
     */
    void init(String ftpServer,String ftpUserName,String password,String serverDir) throws Exception;

    /**
     * 上传
     * @param file
     * @throws Exception
     */
    void upload(File file) throws Exception;

    /**
     * 断开连接
     */
    void disconnect();

}
