package com.meizhuo.DesignPatterns.FunnyDesignPatterns_1.Program4;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_1.Program4
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/2 22:56
 * @UpdateUser:
 * @UpdateDate: 2019/1/2 22:56
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class OperationMul extends Operation {
    @Override
    public double getResult() {
        return getNumA()*getNumB();
    }
}
