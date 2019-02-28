package com.meizhuo.DesignPatterns.FunnyDesignPatterns_24_责任链模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_24_责任链模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/28 11:25
 * @UpdateUser:
 * @UpdateDate: 2019/2/28 11:25
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {

    public static void main(String[] args) {
        BaseHandle handle1 = new ConcreteHandle1();
        BaseHandle handle2 = new ConcreteHandle2();

        handle1.setNextHandle(handle2);

        handle1.handleRequest(4);
        handle1.handleRequest(15);
    }

}
