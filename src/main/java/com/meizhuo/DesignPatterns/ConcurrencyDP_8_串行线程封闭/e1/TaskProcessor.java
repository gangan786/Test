package com.meizhuo.DesignPatterns.ConcurrencyDP_8_串行线程封闭.e1;

/**
 * @Classname TaskProcessor
 * @Description 对任务处理的抽象
 * @param <T> Serializer向WorkerThread所提交的任务对应的类型
 * @param <V> service方法的返回值类型
 * @Date 2019/6/9 20:37
 * @Created by Gangan
 */
public interface TaskProcessor<T, V> {
    /**
     * 对指定任务进行处理
     * @param task 任务
     * @return 处理的结果
     * @throws Exception
     */
    V doProcess(T task) throws Exception;
}
