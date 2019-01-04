package com.meizhuo.DesignPatterns.funnyDesignPatterns_2_策略模式.Cashier1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.funnyDesignPatterns_2_策略模式.Cashier1
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/4 11:16
 * @UpdateUser:
 * @UpdateDate: 2019/1/4 11:16
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {

    public static void main(String[] args) {
        Double total = new Double(0);
        ArrayList<String> commodityList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入单价");
            String price = scanner.nextLine();
            if ("quit".equals(price)) {
                break;
            }
            System.out.println("请输入数量");
            String num = scanner.nextLine();
            Double singleCommodity = Double.valueOf(price) * Double.valueOf(num);
            commodityList.add("单价：" + price + " 数量：" + num + " 总价为："
                    + singleCommodity);
            total = total + singleCommodity;
            showCommodityList(commodityList);
        }

        System.out.println("所有商品的总价为：" + total);
    }

    private static void showCommodityList(ArrayList<String> commodityList) {
        for (String s : commodityList) {
            System.out.println(s);
        }
    }


}
