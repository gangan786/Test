package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No55
 * @Description 完美世界
 * @Date 2019/9/27 19:37
 * @Created by Gangan
 */
public class No55 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int maxWeight = scanner.nextInt();
        int[] weights = new int[count + 1];
        for (int i = 1; i < weights.length; i++) {
            weights[i] = scanner.nextInt();
        }
        int[] values = new int[count + 1];
        for (int i = 1; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }

        int[][] dp = new int[count + 1][maxWeight + 1];

        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (weights[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(values[i] + dp[i - 1][j - weights[i]], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[count][maxWeight]);

    }

}
