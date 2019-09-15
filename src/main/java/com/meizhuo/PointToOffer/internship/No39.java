package com.meizhuo.PointToOffer.internship;

import java.util.Scanner;

/**
 * @Classname No39
 * @Description 换钱的最少货币数
 * @Date 2019/9/15 12:28
 * @Created by Gangan
 */
public class No39 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] arr = new int[count];
        int aim = scanner.nextInt();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int[][] dp = new int[count][aim + 1];
        for (int i = 1; i <= aim; i++) {
            dp[0][i] = Integer.MAX_VALUE;
            if (i - arr[0] >= 0 && dp[0][i - arr[0]] != Integer.MAX_VALUE) {
                dp[0][i] = dp[0][i - arr[0]] + 1;
            }
        }

        for (int i = 1; i < count; i++) {
            for (int j = 1; j <= aim; j++) {
                int left = Integer.MAX_VALUE;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != Integer.MAX_VALUE) {
                    left = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(dp[i - 1][j], left);

            }
        }

        int result = dp[count - 1][aim] == Integer.MAX_VALUE ? -1 : dp[count - 1][aim];
        System.out.println(result);
    }

}
