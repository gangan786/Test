package com.meizhuo.DesignPatterns.FunnyDesignPatterns_1_工厂模式.Program4;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_1.Program4
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/2 23:00
 * @UpdateUser:
 * @UpdateDate: 2019/1/2 23:00
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class OperationFactory {
    public static Operation createOperation(String operation) {
        Operation ope = null;
        switch (operation) {
            case "+":
                ope = new OperationAdd();
                break;
            case "-":
                ope = new OperationSub();
                break;
            case "*":
                ope = new OperationMul();
                break;
            case "/":
                ope = new OperationDiv();
                break;
            default:
                return null;
        }
        return ope;
    }
}
