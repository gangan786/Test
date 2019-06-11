package com.meizhuo.DesignPatterns.ConcurrencyDP_9_主仆;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.Future;

/**
 * @Classname RoundRobinSubTaskDispatchStrategy
 * @Description 简单的轮训派发算法策略
 * @Date 2019/6/10 22:17
 * @Created by Gangan
 */
public class RoundRobinSubTaskDispatchStrategy<T,V> implements SubTaskDispathStrategy<T,V> {


    @SuppressWarnings("unchecked")
    @Override
    public Iterator<Future<V>> dispatch(Set<? extends SlaveSpec<T, V>> slaves,
                                        TaskDivideStrategy<T> divideStrategy) throws InterruptedException {
        LinkedList<Future<V>> futures = new LinkedList<>();
        T subTask;
        Object[] salveArray = slaves.toArray();
        int i=-1;
        final int slaveCount=salveArray.length;
        Future<V> subTaskResultPromise;

        while (null != (subTask = divideStrategy.nextChunk())) {
            i=(i+1)%slaveCount;
            SlaveSpec<T, V> slave = (SlaveSpec<T, V>) salveArray[i];
            subTaskResultPromise = slave.submit(subTask);
            futures.add(subTaskResultPromise);
        }

        return futures.iterator();
    }
}
