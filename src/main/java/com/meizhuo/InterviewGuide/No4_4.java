package com.meizhuo.InterviewGuide;

import java.util.Scanner;

/**
 * @Description 机器人到达指定位置的方法数
 * @Date 2022/4/11
 * @Created by Gangan
 */
public class No4_4 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int P = sc.nextInt();
        System.out.println(test(N,M,K,P));
    }

    public static long test(int N, int M, int K, int P) {
        if(N < 2 || M < 1 || M > N || K < 1 || P < 1 || P > N){
            return 0;
        }
        long mod = (long) Math.pow(10, 9) + 7;
        long[][] data = new long[K + 1][N + 1];
        data[0][P] = 1;
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) {
                    data[i][j] = data[i - 1][2] % mod;
                } else if (j == N) {
                    data[i][j] = data[i - 1][N - 1] % mod;
                } else {
                    data[i][j] = (data[i - 1][j - 1] + data[i - 1][j + 1]) % mod;
                }
            }
        }
        return data[K][M] % mod;
    }

}
