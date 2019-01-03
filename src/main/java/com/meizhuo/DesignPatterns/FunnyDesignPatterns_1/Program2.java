package com.meizhuo.DesignPatterns.FunnyDesignPatterns_1;

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
public class Program2 {
    public static void main(String[] args) {

        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入数字A");
            String numA = scanner.nextLine();
            System.out.println("请选择运算符号：+,-,*,/");
            String operate = scanner.nextLine();
            System.out.println("请输入数字B");
            String numB = scanner.nextLine();
            String result = "";
            switch (operate) {
                case "+":
                    result = String.valueOf(Double.valueOf(numA) + Double.valueOf(numB));
                    break;
                case "-":
                    result = String.valueOf(Double.valueOf(numA) - Double.valueOf(numB));
                    break;
                case "*":
                    result = String.valueOf(Double.valueOf(numA) * Double.valueOf(numB));
                    break;
                case "/":
                    if (Double.valueOf(numB) != 0) {
                        result = String.valueOf(Double.valueOf(numA) / Double.valueOf(numB));
                    } else {
                        result = "除数不能为0";
                    }

                    break;
                default:
                    result = "未知的运算符号";
            }
            System.out.println("结果是：" + result);
        }
        catch (Exception e){
            System.out.println("输入错误：" + e.getMessage());
        }


    }
}
