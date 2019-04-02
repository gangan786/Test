package com.meizhuo.DesignPatterns.ConcurrencyDP_6_主动对象;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_6_主动对象
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/4/2 11:15
 * @UpdateUser:
 * @UpdateDate: 2019/4/2 11:15
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class AsyncRequestPersistence implements RequestPersistence {

    private static final long ONE_MINUTE_IN_SECONDS = 60;

    /**
     * 用于记录所有任务执行总耗时
     */
    private final AtomicLong taskTimerConsumedPerInterval = new AtomicLong(0);
    /**
     * 用于记录请教提交的次数
     */
    private final AtomicInteger requestSubmittedPerInterval = new AtomicInteger(0);

    // 模式角色：ActiveObject.Servant
    private final DiskbasedRequestPersistence delegate =
            new DiskbasedRequestPersistence();

    // 模式角色：ActiveObject.Scheduler
    private final ThreadPoolExecutor scheduler;

    // 用于保存AsyncRequestPersistence的唯一实例
    private static class InstanceHolder {
        final static RequestPersistence INSTANCE =
                new AsyncRequestPersistence();
    }

    /**
     * 私有构造器
     */
    private AsyncRequestPersistence() {
        scheduler = new ThreadPoolExecutor(1,
                3,
                60 * ONE_MINUTE_IN_SECONDS,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(200), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "AsyncRequestPersistence");
            }
        });

        /*
        设置缓冲区饱和后的处理策略，这里使用的是ThreadPoolExecutor提供的
        在任务的提交方（即用户线程）中运行被拒绝的任务
         */
        scheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        //启动队列监控定时任务,每六十秒执行
        Timer monitorTimer = new Timer(true);
        monitorTimer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                if (taskTimerConsumedPerInterval.get() + 200 >= Long.MAX_VALUE ||
                        requestSubmittedPerInterval.get() + 200 >= Integer.MAX_VALUE) {
                    //防止溢出
                    requestSubmittedPerInterval.set(0);
                    taskTimerConsumedPerInterval.set(0);
                }

            }
        }, 0, ONE_MINUTE_IN_SECONDS * 1000);

    }

    @Override
    public void store(MMSDeliverRequest request) {

        //创建任务
        Callable<Boolean> callable = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                long start = System.currentTimeMillis();
                try {
                    //真正的耗时存储
                    delegate.store(request);
                } finally {
                    //记录耗时
                    taskTimerConsumedPerInterval.addAndGet(System.currentTimeMillis() - start);
                }
                return Boolean.TRUE;
            }
        };

        scheduler.submit(callable);
        //增加请求计数
        requestSubmittedPerInterval.incrementAndGet();

    }

    @Override
    public void close() throws IOException {
        scheduler.shutdown();
    }
}
