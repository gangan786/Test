package com.meizhuo.PointToOffer.internship;

import java.util.Scanner;

/**
 * @Classname No25
 * @Description 善变的同伴 参考：https://blog.csdn.net/winter2121/article/details/72848482
 * @Date 2019/8/29 15:49
 * @Created by Gangan
 */
public class No25 {

    private static final int targetMin = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int time = scanner.nextInt();
        int[] values = new int[count + 1];
        for (int i = 1; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }

        int[][] dp = new int[time + 1][count + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = targetMin;
            }
        }

        int maxResult = 0;
        int[][] maxPre = new int[time + 1][count + 1];

        for (int i = 1; i < dp.length; i++) {

            for (int j = i; j < dp[0].length; j++) {
                if (i == 1) {
                    //由于第一行比较特殊，所以单独判断进行构建
                    int self = values[j];
                    int addPre = dp[i][j - 1] + values[j];
                    dp[i][j] = Math.max(self, addPre);
                } else {
                    if (j == i) {
                        //构建每行的第一个元素
                        dp[i][j] = sum(values, j);
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1] + values[j],
                                maxPre[i-1][j-1] + values[j]);
                    }
                }

                maxResult = Math.max(maxResult, dp[i][j]);
                maxPre[i][j] = Math.max(dp[i][j], maxPre[i][j - 1]);
            }
        }

        System.out.println(maxResult);

    }

    private static int sum(int[] values, int endIndex) {
        int sum = 0;
        for (int i = 1; i <= endIndex; i++) {
            sum += values[i];
        }
        return sum;
    }

    public static int getMax(int[] values, int startIndex, int endIndex) {
        int max = Integer.MIN_VALUE;
        for (int i = startIndex; i <= endIndex; i++) {
            max = Math.max(max, values[i]);
        }

        return max;
    }

}
