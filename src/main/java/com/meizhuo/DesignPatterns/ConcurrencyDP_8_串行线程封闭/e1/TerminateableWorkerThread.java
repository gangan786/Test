package com.meizhuo.DesignPatterns.ConcurrencyDP_8_串行线程封闭.e1;

import com.meizhuo.DesignPatterns.ConcurrencyDP_3_两阶段终止.AbstractTerminatableThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @param <T> Serializer向WorkerThread所提交的任务对应的类型
 * @param <V> service方法的返回值类型
 * @Classname TerminateableWorkerThread
 * @Description 串行任务的线程执行者
 * @Date 2019/6/9 20:34
 * @Created by Gangan
 */
public class TerminateableWorkerThread<T, V> extends AbstractTerminatableThread {

    private final BlockingQueue<Runnable> workQueue;

    /**
     * 负责正真执行任务的对象
     */
    private final TaskProcessor<T, V> taskProcessor;

    public TerminateableWorkerThread(BlockingQueue<Runnable> workQueue,
                                     TaskProcessor<T, V> taskProcessor) {
        this.taskProcessor = taskProcessor;
        this.workQueue = workQueue;
    }

    public Future<V> submit(T task) throws InterruptedException {

        /*
         * 构建任务执行内容
         * 并将执行结果返回
         */
        Callable<V> callable = new Callable<V>() {
            @Override
            public V call() throws Exception {
                return taskProcessor.doProcess(task);
            }
        };

        /*
        将任务放进队列中等待被执行
         */
        FutureTask<V> futureTask = new FutureTask<>(callable);
        workQueue.put(futureTask);
        terminationToken.reservations.incrementAndGet();
        return futureTask;
    }

    /**
     * 将列中的任务执行
     * @throws Exception
     */
    @Override
    protected void doRun() throws Exception {
        Runnable take = workQueue.take();
        try {
            take.run();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            terminationToken.reservations.decrementAndGet();
        }

    }
}
