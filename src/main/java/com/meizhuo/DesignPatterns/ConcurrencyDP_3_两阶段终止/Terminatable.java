package com.meizhuo.DesignPatterns.ConcurrencyDP_3_两阶段终止;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_3_两阶段终止
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/24 21:35
 * @UpdateUser:
 * @UpdateDate: 2019/3/24 21:35
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public interface Terminatable {

    /**
     * 终止线程
     */
    void terminate();

}
