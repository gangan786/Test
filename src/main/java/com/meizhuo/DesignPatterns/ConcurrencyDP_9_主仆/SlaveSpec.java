package com.meizhuo.DesignPatterns.ConcurrencyDP_9_主仆;

import java.util.concurrent.Future;

/**
 * @description 仆从工作者的抽象
 * @param <T> 子任务类型
 * @param <V> 子任务处理结果类型
 */
public interface SlaveSpec<T, V> {

    /**
     * 用于Master（主）向Slave（从）提交任务
     * @param task 子任务
     * @return 获取处理结果
     * @throws InterruptedException
     */
    Future<V> submit(final T task) throws InterruptedException;

    /**
     * 启动Slave服务
     */
    void init();

    /**
     * 安全关闭Slave服务
     */
    void shutdown();

}
