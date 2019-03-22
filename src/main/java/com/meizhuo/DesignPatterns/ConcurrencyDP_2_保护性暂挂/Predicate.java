package com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/21 14:45
 * @UpdateUser:
 * @UpdateDate: 2019/3/21 14:45
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public interface Predicate {

    /**
     * 返回与告警服务器的连接状态
     * @return
     */
    boolean evaluate();

}
