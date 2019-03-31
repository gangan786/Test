package com.meizhuo.DesignPatterns.ConcurrencyDP_5_生产消费;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_5_生产消费
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/31 10:52
 * @UpdateUser:
 * @UpdateDate: 2019/3/31 10:52
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public interface Channel<P> {

    /**
     * 从通道中取出一个产品
     * @return
     */
    P take() throws InterruptedException;

    /**
     * 往通道中存入一个产品
     * @param product
     * @throws InterruptedException
     */
    void put(P product) throws InterruptedException;

}
