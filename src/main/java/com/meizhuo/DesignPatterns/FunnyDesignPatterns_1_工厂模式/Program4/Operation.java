package com.meizhuo.DesignPatterns.FunnyDesignPatterns_1_工厂模式.Program4;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_1.Program4
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/2 22:50
 * @UpdateUser:
 * @UpdateDate: 2019/1/2 22:50
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public abstract class Operation {

    private double numA = 0;
    private double numB = 0;

    /**
     * 获取运算结果
     * @return 结果
     */
    public abstract double getResult();

    public double getNumA() {
        return numA;
    }

    public void setNumA(double numA) {
        this.numA = numA;
    }

    public double getNumB() {
        return numB;
    }

    public void setNumB(double numB) {
        this.numB = numB;
    }
}
