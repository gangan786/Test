package com.meizhuo.DesignPatterns.ConcurrencyDP_5_生产消费;

import java.util.concurrent.BlockingQueue;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_5_生产消费
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/31 10:55
 * @UpdateUser:
 * @UpdateDate: 2019/3/31 10:55
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class BlockingQueueChannel<P> implements Channel<P> {

    private final BlockingQueue<P> queue;

    public BlockingQueueChannel(BlockingQueue<P> queue) {
        this.queue = queue;
    }

    @Override
    public P take() throws InterruptedException {
        return queue.take();
    }

    @Override
    public void put(P product) throws InterruptedException {
        queue.put(product);
    }
}
