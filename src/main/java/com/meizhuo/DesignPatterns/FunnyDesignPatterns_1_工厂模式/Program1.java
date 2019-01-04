package com.meizhuo.DesignPatterns.FunnyDesignPatterns_1_工厂模式;

import java.util.Scanner;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_1
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/2 22:09
 * @UpdateUser:
 * @UpdateDate: 2019/1/2 22:09
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Program1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字A");
        String A = scanner.nextLine();
        System.out.println("请选择运算符号：+,-,*,/");
        String B = scanner.nextLine();
        System.out.println("请输入数字B");
        String C = scanner.nextLine();
        String D = "";
        if ("+".equals(B)) {
            D = String.valueOf(Double.valueOf(A) + Double.valueOf(C));
        }
        if ("-".equals(B)) {
            D = String.valueOf(Double.valueOf(A) - Double.valueOf(C));
        }
        if ("*".equals(B)) {
            D = String.valueOf(Double.valueOf(A) * Double.valueOf(C));
        }
        if ("/".equals(B)) {
            D = String.valueOf(Double.valueOf(A) / Double.valueOf(C));
        }
        System.out.println("结果是：" + D);
    }
}
