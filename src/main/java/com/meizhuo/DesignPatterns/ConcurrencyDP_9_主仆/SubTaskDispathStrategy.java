package com.meizhuo.DesignPatterns.ConcurrencyDP_9_主仆;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Future;

/**
 * @Classname SubTaskDispathStrategy
 * @Description 对子任务派发算法策略的抽象
 * @Date 2019/6/10 21:52
 * @Created by Gangan
 * @param <T>子任务类型
 * @param <V>子任务处理结果类型
 */
public interface SubTaskDispathStrategy<T,V> {

    /**
     * 根据指定的任务分解策略，将原始任务分解成各个子任务
     * @param slaves 处理子任务的一群Slave实例集合
     * @param divideStrategy 分解策略
     * @return 遍历该Iterator可得到用于获取处理结果的Future
     * @throws InterruptedException 当Slave工作者线程被中断时抛出异常
     */
    Iterator<Future<V>> dispatch(Set<? extends SlaveSpec<T,V>> slaves,
                                 TaskDivideStrategy<T> divideStrategy)throws InterruptedException;

}
