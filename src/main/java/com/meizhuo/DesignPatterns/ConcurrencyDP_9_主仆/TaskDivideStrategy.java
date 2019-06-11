package com.meizhuo.DesignPatterns.ConcurrencyDP_9_主仆;

/**
 * @author Gangan
 * @date 2019年6月10日21:46:30
 * @param <T> 子任务类型
 * @description 对原始任务分解算法策略的抽象
 *
 */
public interface TaskDivideStrategy<T> {

    /**
     * 返回下一个任务
     * 若返回值为null，则表示无后续子任务
     * @return
     */
    T nextChunk();

}
