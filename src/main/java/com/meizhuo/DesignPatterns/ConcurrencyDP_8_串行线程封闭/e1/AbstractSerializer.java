package com.meizhuo.DesignPatterns.ConcurrencyDP_8_串行线程封闭.e1;

import com.meizhuo.DesignPatterns.ConcurrencyDP_3_两阶段终止.Terminatable;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;

/**
 * Serializer参与者可复用实现
 *
 * @param <T> Serializer向WorkerThread所提交的任务对应的类型
 * @param <V> service方法的返回值类型
 */
public abstract class AbstractSerializer<T, V> {


    private final TerminateableWorkerThread<T, V> workerThread;

    public AbstractSerializer(BlockingQueue<Runnable> workQueue,
                              TaskProcessor<T, V> taskProcessor) {
        workerThread = new TerminateableWorkerThread<T, V>(workQueue, taskProcessor);
    }

    /**
     * 留给子类实现
     * 用于根据指定参数生成相应的任务实例
     *
     * @param params
     * @return 任务实例 用于提交给WorkerQueue
     */
    protected abstract T makeTask(Object... params);

    /**
     * 该类对外暴露的服务方法
     * @param params
     * @return 任务处理结果
     * @throws InterruptedException
     */
    protected Future<V> service(Object... params) throws InterruptedException {
        T task = makeTask(params);
        Future<V> future = workerThread.submit(task);
        return future;
    }

    /**
     * 启动线程处理任务
     */
    public void init() {
        workerThread.start();
    }

    /**
     * 安全结束该线程
     */
    public void shutdown() {
        workerThread.terminate();
    }
}
