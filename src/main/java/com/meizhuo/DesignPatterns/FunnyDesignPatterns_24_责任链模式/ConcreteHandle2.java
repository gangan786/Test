package com.meizhuo.DesignPatterns.FunnyDesignPatterns_24_责任链模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_24_责任链模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/28 11:21
 * @UpdateUser:
 * @UpdateDate: 2019/2/28 11:21
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class ConcreteHandle2 extends BaseHandle {
    @Override
    public void handleRequest(int requestLevel) {
        if (requestLevel > 10 && requestLevel < 20) {
            System.out.println(this.getClass().getName() + "执行请求完毕，请求权限：" + requestLevel);
        } else {
            if (nextHandle != null) {
                nextHandle.handleRequest(requestLevel);
            }
        }
    }
}
