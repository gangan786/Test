package com.meizhuo.DesignPatterns.ConcurrencyDP_5_生产消费;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_5_生产消费
 * @ClassName: ${TYPE_NAME}
 * @Description: 基于流量控制的通道实现
 * @Author: Gangan
 * @CreateDate: 2019/3/31 12:04
 * @UpdateUser:
 * @UpdateDate: 2019/3/31 12:04
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class SemaphoreBasedChannel<P> implements Channel<P> {

    private final BlockingQueue<P> queue;

    private final Semaphore semaphore;

    /**
     *
     * @param queue 通常是一个阻塞误解队列
     * @param flowLimit 生产者并发限制的线程数
     */
    public SemaphoreBasedChannel(BlockingQueue queue, int flowLimit) {
        this.queue = queue;
        this.semaphore = new Semaphore(flowLimit);
    }

    @Override
    public P take() throws InterruptedException {
        return queue.take();
    }

    @Override
    public void put(P product) throws InterruptedException {
        semaphore.acquire();
        try {
            queue.put(product);
        }finally {
            semaphore.release();
        }
    }
}
