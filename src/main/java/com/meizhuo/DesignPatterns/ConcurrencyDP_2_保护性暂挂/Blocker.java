package com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂;

import java.util.concurrent.Callable;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/21 14:36
 * @UpdateUser:
 * @UpdateDate: 2019/3/21 14:36
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public interface Blocker {

    /**
     * 在保护条件成立时执行目标动作；否则阻塞当前线程，直到保护条件成立
     * @param guardedAction 带保护条件的目标动作
     * @param <V>
     * @return
     * @throws Exception
     */
    <V> V callWithGuard(GuardedAction<V> guardedAction) throws Exception;

    /**
     * 执行stateOperation所指定的操作之后，决定是否唤醒Blocker
     * 所暂挂的所有线程中的一个线程
     * @param sateOperation 更改状态的操作，其call方法的返回值为TRUE时，该方法才会唤醒被暂挂的线程
     * @throws Exception
     */
    void singleAfter(Callable<Boolean> sateOperation) throws Exception;

    void single() throws Exception;

    /**
     * 执行stateOperation所指定的操作后，决定是否唤醒Blocker
     * 所暂挂的所有线程
     * @param stateOperation
     * @throws Exception
     */
    void broadcastAfter(Callable<Boolean> stateOperation) throws Exception;

}
