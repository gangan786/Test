package com.meizhuo.DesignPatterns.ConcurrencyDP_3_两阶段终止;

import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_3_两阶段终止
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/24 21:38
 * @UpdateUser:
 * @UpdateDate: 2019/3/24 21:38
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class TerminationToken {

    /**
     * 关闭告警系统的标志
     * 使用 volatile 修饰，以保障无须显式锁的情况下该变量的内存可见性
     */
    private volatile boolean toShutdown = false;

    /**
     * 用于记录待处理的任务数
     */
    public final AtomicInteger reservations = new AtomicInteger(0);

    /**
     * 在多个可停止线程实例共享一个TerminationToken实例的情况下，该队列用于记录那些共享
     * TerminationToken实例的可停止线程，以便尽可能减少锁的使用情况下，实现这些线程的停止
     */
    private final Queue<WeakReference<Terminatable>> coordinatedThreads;

    public TerminationToken() {
        coordinatedThreads = new ConcurrentLinkedQueue<>();
    }

    public boolean isToShutdown() {
        return toShutdown;
    }

    public void setToShutdown(boolean toShutdown) {
        this.toShutdown = true;
    }

    protected void register(Terminatable thread) {
        coordinatedThreads.add(new WeakReference<Terminatable>(thread));
    }

    /**
     * 通知TerminationToken实例：共享该实例的所有可停止线程中的一个线程停止了，
     * 以便其停止其他未被停止的线程
     * @param thread 调用此方法的线程已执行完terminate方法
     */
    protected void notifyThreadTermination(Terminatable thread) {
        WeakReference<Terminatable> weakThread;
        Terminatable otherThread;
        while (null != (weakThread = coordinatedThreads.poll())) {
            otherThread = weakThread.get();
            if (null != otherThread && otherThread != thread) {
                /*
                    调用除参数thread外其他线程的terminate方法
                    实现任务的终止执行
                 */
                otherThread.terminate();
            }
        }
    }

}
