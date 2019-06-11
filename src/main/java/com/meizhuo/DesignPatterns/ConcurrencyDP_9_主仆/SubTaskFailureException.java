package com.meizhuo.DesignPatterns.ConcurrencyDP_9_主仆;

/**
 * @Classname SubTaskFailureException
 * @Description 表示子任务处理失败的异常
 * @Date 2019/6/11 15:12
 * @Created by Gangan
 */
public class SubTaskFailureException extends Exception {

    public final RetryInfo retryInfo;

    public SubTaskFailureException(RetryInfo retryInfo, Exception exception) {
        super(exception);
        this.retryInfo=retryInfo;
    }

}
