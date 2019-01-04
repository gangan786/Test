package com.meizhuo.DesignPatterns.FunnyDesignPatterns_1_工厂模式.Program4;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_1.Program4
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/2 22:57
 * @UpdateUser:
 * @UpdateDate: 2019/1/2 22:57
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class OperationDiv extends Operation {
    @Override
    public double getResult() {
        if (getNumB() == 0) {
            throw new RuntimeException("除数不能为0");
        } else {
            return getNumA() / getNumB();
        }
    }
}
