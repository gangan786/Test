package com.meizhuo.DesignPatterns.ConcurrencyDP_9_主仆;

import com.meizhuo.DesignPatterns.ConcurrencyDP_3_两阶段终止.AbstractTerminatableThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Classname WorkerThreadSlave
 * @Description Salve（仆）工作线程的具体实现
 * @Date 2019/6/11 14:42
 * @Created by Gangan
 */
public abstract class WorkerThreadSlave<T, V>
        extends AbstractTerminatableThread
        implements SlaveSpec<T, V> {

    private final BlockingQueue<Runnable> taskQueue;

    public WorkerThreadSlave(BlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public Future<V> submit(T task) throws InterruptedException {

        FutureTask<V> futureTask = new FutureTask<V>(new Callable<V>() {
            @Override
            public V call() throws Exception {
                //组装处理结果
                V result = null;
                /*
                执行用户操作
                并返回带结果的对象
                 */
                try {
                    result = doProcess(task);
                } catch (Exception e) {
                    SubTaskFailureException safe = newSunFailureException(task, e);
                    throw safe;
                }
                return result;
            }
        });
        //将任务放进处理队列中等待doRun方法处理
        taskQueue.put(futureTask);
        terminationToken.reservations.incrementAndGet();
        return futureTask;

    }

    private SubTaskFailureException newSunFailureException(T task, Exception e) {
        RetryInfo<T, V> retryInfo = new RetryInfo<>(task, new Callable<V>() {
            @Override
            public V call() throws Exception {
                /*
                失败策略为重试
                 */
                V result;
                result = doProcess(task);
                return result;
            }
        });
        return new SubTaskFailureException(retryInfo, e);
    }


    /**
     * 用于定义子任务的处理逻辑
     * 留给用户自行实现
     *
     * @param task
     * @return
     * @throws Exception
     */
    protected abstract V doProcess(T task) throws Exception;

    /**
     * 仆从线程开启服务
     */
    @Override
    public void init() {
        this.start();
    }

    /**
     * 关闭仆从线程
     */
    @Override
    public void shutdown() {
        this.terminate();
    }

    @Override
    protected void doRun() throws Exception {
        try {
            //线程循环执行
            Runnable task = taskQueue.take();
            task.run();
        }finally {
            terminationToken.reservations.decrementAndGet();
        }
    }
}
