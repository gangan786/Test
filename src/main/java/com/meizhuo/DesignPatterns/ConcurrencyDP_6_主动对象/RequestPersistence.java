package com.meizhuo.DesignPatterns.ConcurrencyDP_6_主动对象;

import java.io.Closeable;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_6_主动对象
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/4/2 11:17
 * @UpdateUser:
 * @UpdateDate: 2019/4/2 11:17
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public interface RequestPersistence extends Closeable {

    void store(MMSDeliverRequest request);

}
