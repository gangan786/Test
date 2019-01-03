package com.meizhuo.DesignPatterns.FunnyDesignPatterns_1.Program3;

import java.util.Scanner;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_1.Program3
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/2 22:45
 * @UpdateUser:
 * @UpdateDate: 2019/1/2 22:45
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入数字A");
            String numA = scanner.nextLine();
            System.out.println("请选择运算符号：+,-,*,/");
            String operate = scanner.nextLine();
            System.out.println("请输入数字B");
            String numB = scanner.nextLine();
            String result = "";
            System.out.println("结果是：" + Operation.getResult(Double.valueOf(numA), Double.valueOf(numB), operate));

        } catch (Exception e) {
            System.out.println("你的输入有错误" + e.getMessage());
        }

    }
}
