package com.meizhuo.DesignPatterns.FunnyDesignPatterns_1_工厂模式.Program4;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_1.Program4
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/2 22:54
 * @UpdateUser:
 * @UpdateDate: 2019/1/2 22:54
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class OperationAdd extends Operation {
    @Override
    public double getResult() {
        return getNumA()+getNumB();
    }
}
