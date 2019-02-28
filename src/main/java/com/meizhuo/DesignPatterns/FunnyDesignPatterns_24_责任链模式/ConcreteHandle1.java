package com.meizhuo.DesignPatterns.FunnyDesignPatterns_24_责任链模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_24_责任链模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/28 11:11
 * @UpdateUser:
 * @UpdateDate: 2019/2/28 11:11
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class ConcreteHandle1 extends BaseHandle {

    @Override
    public void handleRequest(int requestLevel) {
        if (requestLevel > 0 && requestLevel < 10) {
            System.out.println(this.getClass().getName() + "执行请求完毕，请求权限：" + requestLevel);
        } else {
            if (nextHandle != null) {
                nextHandle.handleRequest(requestLevel);
            }
        }
    }
}
