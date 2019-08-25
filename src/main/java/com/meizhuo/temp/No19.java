package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No19
 * @Description 快手笔试_版本比较
 * @Date 2019/8/25 16:56
 * @Created by Gangan
 */
public class No19 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        String[] testList = new String[count];


        for (int i = 0; i < testList.length; i++) {
            testList[i]=scanner.next()+" "+scanner.next();
        }


        for (int i = 0; i < testList.length; i++) {
            //获取第一个测试用例
            String[] sum = testList[i].split(" ");
            String[] leftWithNoPoint = sum[0].split("\\.");
            String[] rightWithNoPoint = sum[1].split("\\.");
            boolean isSame=false;
            int maxLength = Math.max(leftWithNoPoint.length, rightWithNoPoint.length);
            //比较两个版本号
            for (int j = 0; j < maxLength; j++) {
                int leftNum = 0;
                int rightNum = 0;
                if (j < leftWithNoPoint.length) {
                    leftNum = Integer.valueOf(leftWithNoPoint[j]);
                }
                if (j < rightWithNoPoint.length) {
                    rightNum = Integer.valueOf(rightWithNoPoint[j]);
                }

                if (leftNum - rightNum > 0) {
                    //不符合条件
                    System.out.println("false");
                    break;
                }

                if (leftNum != rightNum) {
                    isSame=true;
                }

                if (j == maxLength - 1) {
                    if (!isSame) {
                        System.out.println("false");
                    } else {
                        System.out.println("true");
                    }
                }

            }
        }

    }

}
