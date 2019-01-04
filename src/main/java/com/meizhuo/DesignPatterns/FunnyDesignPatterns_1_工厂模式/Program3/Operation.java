package com.meizhuo.DesignPatterns.FunnyDesignPatterns_1_工厂模式.Program3;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_1.Program3
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/2 22:39
 * @UpdateUser:
 * @UpdateDate: 2019/1/2 22:39
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Operation {
    public static double getResult(double numA, double numB, String operation) {
        double result = 0d;
        switch (operation) {
            case "+":
                result = numA+numB;
                break;
            case "-":
                result = numA-numB;
                break;
            case "*":
                result = numA*numB;
                break;
            case "/":
                    result = numA/numB;
                break;
            default:
                result = 0;
        }
        return result;
    }
}
