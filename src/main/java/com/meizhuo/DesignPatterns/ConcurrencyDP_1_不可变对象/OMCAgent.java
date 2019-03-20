package com.meizhuo.DesignPatterns.ConcurrencyDP_1_不可变对象;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_1_不可变对象
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/20 22:17
 * @UpdateUser:
 * @UpdateDate: 2019/3/20 22:17
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class OMCAgent implements Runnable {
    @Override
    public void run() {
        //当对获得最新路由表时，更新数据库，并且重新加载彩信中心路由规则管理器的内容
        MMSCRouter.setInstance(new MMSCRouter());
        //省略其他代码
    }
}
