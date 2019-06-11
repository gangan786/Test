package com.meizhuo.DesignPatterns.ConcurrencyDP_9_主仆;

import java.util.concurrent.Callable;

/**
 * @Classname RetryInfo
 * @Description 对失败子任务进行重试所需的信息
 * @Date 2019/6/11 15:17
 * @Created by Gangan
 * @param <T> 子任务类型
 * @param <V> 子任务处理结果类型
 */
public class RetryInfo<T,V> {

    public final T subTask;
    public final Callable<V> redoCommand;

    public RetryInfo(T sunTask, Callable<V> redoCommand) {
        this.subTask = sunTask;
        this.redoCommand = redoCommand;
    }
}
