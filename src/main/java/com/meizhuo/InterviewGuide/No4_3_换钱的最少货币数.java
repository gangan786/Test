package com.meizhuo.InterviewGuide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description 给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
 * @Date 2022/5/29
 * @Created by Gangan
 */
public class No4_3_换钱的最少货币数 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int[] arr = parse(str,2);
        int n = arr[0];
        int amount = arr[1];
        arr = parse(reader.readLine().split(" "),n);
        reader.close();
        System.out.println(getMinCoins(arr,amount));
    }

    public static int getMinCoins(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dep = new int[N + 1][aim + 1];
        //dep[N][0]=0
        for (int i = 1; i <= aim; i++) {
            dep[N][i] = -1;
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j <= aim; j++) {
                dep[i][j] = -1;
                if (dep[i + 1][j] != -1) {
                    dep[i][j] = dep[i + 1][j];
                }
                if (j - arr[i] >= 0 && dep[i][j - arr[i]] != -1) {
                    if (dep[i][j] == -1) {
                        dep[i][j] = dep[i][j - arr[i]] + 1;
                    } else {
                        dep[i][j] = Math.min(dep[i][j], dep[i][j - arr[i]] + 1);
                    }
                }
            }
        }
        return dep[0][aim];
    }
    private static int[] parse(String[] str,int len){
        int[] arr = new int[len];
        for(int i= 0;i < len;++i){
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }
}
