package com.meizhuo.DesignPatterns.ConcurrencyDP_9_主仆;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Future;

/**
 * @param <T> 子任务处理类型
 * @param <V> 子任务处理结果类型
 * @param <R> 原始任务处理结果类型
 * @Classname AbstractMaster
 * @Description Master 用于统筹所有Slave并统计子任务的处理结果
 * @Date 2019/6/11 15:52
 * @Created by Gangan
 */
public abstract class AbstractMaster<T, V, R> {

    protected volatile Set<? extends SlaveSpec<T, V>> slaveSet;

    /**
     * 子任务派发策略
     */
    private volatile SubTaskDispathStrategy<T, V> subTaskDispathStrategy;

    /**
     * 初始化
     * 创建仆从实例并启动仆从线程
     * 创建分发策略实例
     */
    protected void init() {
        slaveSet = createSlavers();
        subTaskDispathStrategy = newSubTaskDispathStrategy();
        for (SlaveSpec<T, V> slaveSpec : slaveSet) {
            slaveSpec.init();
        }
    }

    protected R service(Object... params) throws Exception {
        final TaskDivideStrategy<T> taskDivideStrategy = newTaskDivideStrategy(params);
        Iterator<Future<V>> futureIterator = subTaskDispathStrategy.dispatch(slaveSet, taskDivideStrategy);

        //等待Slave处理结果完毕
        for (SlaveSpec<T, V> slaveSpec : slaveSet) {
            slaveSpec.shutdown();
        }

        //合并子任务处理结果
        R result = combineResults(futureIterator);
        return result;
    }

    /**
     * 由子类实现
     * 用于指定合并子任务
     *
     * @param futureIterator
     * @return
     */
    protected abstract R combineResults(Iterator<Future<V>> futureIterator);

    /**
     * 由子类实现
     * 用于创建原始任务分解算法策略
     *
     * @param params
     * @return
     */
    protected abstract TaskDivideStrategy<T> newTaskDivideStrategy(Object[] params);

    /**
     * 留给子类实现
     * 用于指定子任务分发策略
     *
     * @return
     */
    protected abstract SubTaskDispathStrategy<T, V> newSubTaskDispathStrategy();

    /**
     * 留给子类实现
     * 用于创建Slave实例
     *
     * @return
     */
    protected abstract Set<? extends SlaveSpec<T, V>> createSlavers();


}
