package com.meizhuo.DesignPatterns.ConcurrencyDP_1_不可变对象;

import org.junit.Test;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_1_不可变对象
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/20 22:25
 * @UpdateUser:
 * @UpdateDate: 2019/3/20 22:25
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {

    @Test
    public void test(){
        //假设这里获取彩信中心的逻辑被多条线程并发执行
        MMSCInfo info1 = MMSCRouter.getInstance().getMMSCInfo("1500");
        System.out.println(info1);

        //路由表更新
        Thread thread = new Thread(new OMCAgent());
        thread.start();

        MMSCInfo info2 = MMSCRouter.getInstance().getMMSCInfo("1501");
        System.out.println(info2);

    }

}
