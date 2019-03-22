package com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂;

import java.util.concurrent.Callable;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/21 14:42
 * @UpdateUser:
 * @UpdateDate: 2019/3/21 14:42
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public abstract class GuardedAction<V> implements Callable<V> {

    protected final Predicate guard;

    public GuardedAction(Predicate guard) {
        this.guard = guard;
    }
}
