package com.meizhuo.InterviewGuide;

import java.util.Scanner;

/**
 * @Description 给定数组arr，设数组长度为n，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim，代表要找的钱数，求换钱的方法数有多少种
 * @Date 2022/5/30
 * @Created by Gangan
 */
public class No4_5_换钱的方法数 {

    public static int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int aim = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(getCount(arr, aim));
    }


    public static int getCount(int[] arr, int aim) {
        int N = arr.length;
        if (arr == null || N == 0 || aim == 0) {
            return 0;
        }
        int[][] dp = new int[N][aim + 1];
        //第一行
        for (int i = 0; arr[0] * i <= aim; i++) {
            dp[0][arr[0] * i] = 1;
        }
        //第一列
        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j] % mod;
                if (j - arr[i] >= 0) {
                    dp[i][j] += (dp[i][j - arr[i]]) % mod;
                }
                dp[i][j] = (dp[i][j] + (j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0)) % mod;
            }
        }
        return dp[N - 1][aim];
    }
}
