package com.meizhuo.DesignPatterns.ConcurrencyDP_6_主动对象;

import java.util.concurrent.*;

/**
 * @Classname SampleClientOfReusableActiveObject
 * @Description TODO
 * @Date 2019/4/5 10:19
 * @Created by Gangan
 */
public class SampleClientOfReusableActiveObject {

    public static void main(String[] args)
            throws InterruptedException, ExecutionException {


        //Alibaba推荐的线程池创建方式
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,
                Runtime.getRuntime().availableProcessors() * 2,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(200),
                r -> {
                    Thread handleThread = new Thread(r, "handle thread");
                    handleThread.setDaemon(true);
                    return handleThread;
                });

        SampleActiveObject sao = ActiveObjectProxy.newInstance(
                SampleActiveObject.class, new SampleActiveObjectImpl(),
                poolExecutor);
        Future<String> ft = null;

        System.out.println("Before calling active object");
        try {
            ft = sao.process("Something", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // 模拟其他操作的时间消耗
            Thread.sleep(40);
            System.out.println("开始运行");

            System.out.println(ft.get());
            System.out.println("结束运行");
        } finally {
            //完成任务关闭线程池
            poolExecutor.shutdown();
        }


    }

}
