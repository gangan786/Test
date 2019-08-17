package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No11
 * @Description 找楼
 * @Date 2019/8/17 20:42
 * @Created by Gangan
 */
public class No11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countBuilding = scanner.nextInt();
        int[] highs = new int[countBuilding];
        for (int i = 0; i < highs.length; i++) {
            highs[i] = scanner.nextInt();
        }
        int[] result = new int[countBuilding];
        for (int i = 0; i < highs.length; i++) {
            //左边
            int left = 0;
            int leftMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (highs[j] > leftMax) {
                    leftMax = highs[j];
                    left++;
                }
            }
            //右边
            int right = 0;
            int rightMax = 0;
            for (int j = i + 1; j < highs.length; j++) {
                if (highs[j] > rightMax) {
                    rightMax = highs[j];
                    right++;
                }
            }

            result[i] = left + right + 1;
        }

        //输出结果
        for (int i = 0; i < result.length; i++) {
            if (i == result.length - 1) {
                System.out.print(result[i]);
            } else {
                System.out.print(result[i] + " ");
            }
        }
    }

}
