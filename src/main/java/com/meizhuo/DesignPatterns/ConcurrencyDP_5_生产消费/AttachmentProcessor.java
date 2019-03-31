package com.meizhuo.DesignPatterns.ConcurrencyDP_5_生产消费;

import com.meizhuo.DesignPatterns.ConcurrencyDP_3_两阶段终止.AbstractTerminatableThread;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.Normalizer;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_5_生产消费
 * @ClassName: ${TYPE_NAME}
 * @Description: 充当生产者的角色
 * @Author: Gangan
 * @CreateDate: 2019/3/31 10:47
 * @UpdateUser:
 * @UpdateDate: 2019/3/31 10:47
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class AttachmentProcessor {

    private final String ATTACMENT_STORE_BASE_DIR = "home/viscent/tmp/attachments";

    private final Channel<File> channel =
            new BlockingQueueChannel<>
                    (new ArrayBlockingQueue<>(200));


    /**
     * 使用两段终止模式来构造消费者线程
     */
    private final AbstractTerminatableThread indexingThread =
            new AbstractTerminatableThread() {
                @Override
                protected void doRun() throws Exception {
                    File file = null;
                    file = channel.take();
                    try {
                        indexFile(file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        //处理完索引后，任务计数减一
                        terminationToken.reservations.decrementAndGet();
                    }
                }

                /**
                 * 模拟生成索引耗时操作
                 * @param file
                 * @throws Exception
                 */
                private void indexFile(File file) throws Exception {
                    Random random = new Random();
                    Thread.sleep(random.nextInt(100));
                }
            };

    /**
     * 启动消费者线程
     */
    public void init() {
        indexingThread.start();
    }

    /**
     * 终止消费者线程
     */
    public void shutdown() {
        indexingThread.terminate();
    }

    /**
     * 将文件保存并将该文件放入生产消费队列中
     * 以供消费者消费产生索引
     * @param inputStream
     * @param documentId
     * @param originalName
     * @throws IOException
     */
    public void saveAttachment(InputStream inputStream,String documentId,
                               String originalName) throws IOException {
        // 将附件保存为文件
        File file = saveAsFile(inputStream, documentId, originalName);
        try {
            channel.put(file);
            indexingThread.terminationToken.reservations.incrementAndGet();
        } catch (InterruptedException e) {
            ;
        }
    }

    private File saveAsFile(InputStream inputStream
            , String documentId, String originalName) throws IOException {
        String dirName = ATTACMENT_STORE_BASE_DIR + documentId;
        File dir = new File(dirName);
        dir.mkdirs();
        File file =
                new File(dirName + '/'
                        + Normalizer.normalize(originalName,
                        Normalizer.Form.NFC));

        // 防止目录跨越攻击
        if (!new File(dirName)
                .equals(new File(file.getCanonicalFile().getParent()))) {
            throw new SecurityException(
                    "Invalid originalFileName:" + originalName);
        }
        try (InputStream dataIn = inputStream) {
            Files.copy(dataIn, Paths.get(file.getCanonicalPath()),
                    StandardCopyOption.REPLACE_EXISTING);
        }
        return file;
    }

}
