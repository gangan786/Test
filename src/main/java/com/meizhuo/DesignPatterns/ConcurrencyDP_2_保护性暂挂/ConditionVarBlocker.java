package com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/21 14:59
 * @UpdateUser:
 * @UpdateDate: 2019/3/21 14:59
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class ConditionVarBlocker implements Blocker {

    private final Lock lock;

    private final Condition condition;

    /**
     * 构造
     * @param lock 防止出现嵌套监视器锁死
     */
    public ConditionVarBlocker(Lock lock) {
        this.lock = lock;
        this.condition = lock.newCondition();
    }

    public ConditionVarBlocker() {
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    @Override
    public <V> V callWithGuard(GuardedAction<V> guardedAction) throws Exception {
        lock.lockInterruptibly();
        V result;
        try {
            final Predicate guard = guardedAction.guard;
            while (!guard.evaluate()) {
                //guard.evaluate()返回的是AlarmAgent所维护的是与告警服务器之间连接的可用性
                //表示网络连接不可用，调用线程处于等待状态
                //当执行此方法的线程被唤醒之后，并不能保证此时的保护条件的是成立的，
                //因此使用while循环继续检测保护条件
                condition.await();
            }
            //表示连接正常，向告警服务器发送告警信息
            result = guardedAction.call();
            return result;
        } finally {
            /**
             * 为了防止锁泄漏，持有锁的线程一定要记得释放锁
             */
            lock.unlock();
        }
    }

    @Override
    public void singleAfter(Callable<Boolean> sateOperation) throws Exception {
        lock.lockInterruptibly();
        try {
            if (sateOperation.call()) {
                condition.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void single() throws Exception {
        lock.lockInterruptibly();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void broadcastAfter(Callable<Boolean> stateOperation) throws Exception {
        lock.lockInterruptibly();
        try {
            if (stateOperation.call()) {
                condition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}
