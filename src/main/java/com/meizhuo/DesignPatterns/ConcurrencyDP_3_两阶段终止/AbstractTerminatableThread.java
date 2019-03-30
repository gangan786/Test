package com.meizhuo.DesignPatterns.ConcurrencyDP_3_两阶段终止;

import java.util.concurrent.Executors;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_3_两阶段终止
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/24 21:22
 * @UpdateUser:
 * @UpdateDate: 2019/3/24 21:22
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public abstract class AbstractTerminatableThread extends Thread implements Terminatable {

    public final TerminationToken terminationToken;

    public AbstractTerminatableThread() {
        this(new TerminationToken());
    }

    public AbstractTerminatableThread(TerminationToken terminationToken) {
        super();
        this.terminationToken = terminationToken;
        terminationToken.register(this);

    }

    /**
     * 留给子类实现其线程处理逻辑
     *
     * @throws Exception
     */
    protected abstract void doRun() throws Exception;

    /**
     * 留给子类实现，用于实现线程停止后的一些清理动作
     *
     * @param cause
     */
    protected void doCleanup(Exception cause) {
        //什么也不做
    }

    /**
     * 留给子类实现。用于执行线程停止所需的操作
     */
    protected void doTerminiate() {
        //什么也不做
    }

    @Override
    /**
     * 通过对TerminationToken的toShutdown属性和reservations属性判断  或者
     * 通过捕获由interrupt方法调用而抛出的异常来终止线程
     * 并调用doCleanup方法用于执行一些清理操作
     */
    public void run() {
        Exception ex = null;
        try {
            for (; ; ) {
                //在执行线程的处理逻辑前先判断线程停止的标志
                if (terminationToken.isToShutdown()
                        && terminationToken.reservations.get() <= 0) {
                    /**
                     * 目标线程发送完队列中现有的告警信息后，duRun方法不再被调用
                     * 从而避免了队列为空时BlockingQueue.take调用导致的阻塞
                     * TODO：以上是书中的解释，可是查看此段代码发现，当队列为空时，也不一定能执行 break
                     * TODO： 继而继续调用doRun导致阻塞
                     */
                    break;
                }
                doRun();
            }
        } catch (Exception e) {
            ex = e;
        } finally {
            //此时已经关闭了告警发送服务
            try {
                doCleanup(ex);
            } finally {
                terminationToken.notifyThreadTermination(this);
            }
        }
    }

    @Override
    public void interrupt() {
        terminate();
    }

    /**
     * 请求停止线程
     * 完成线程停止的准备阶段
     */
    @Override
    public void terminate() {
        terminationToken.setToShutdown(true);
        try {
            doTerminiate();
        } finally {
            //若无待处理的任务，则试图强制终止线程
            if (terminationToken.reservations.get() <= 0) {
                super.interrupt();
            }
        }
    }

    /**
     * 此方法用于被客户线程调用
     * @param waitUtilThreadTerminated
     */
    public void terminate(boolean waitUtilThreadTerminated) {
        terminate();
        if (waitUtilThreadTerminated) {
            try {
                this.join();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
