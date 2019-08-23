package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No17
 * @Description 依图笔试_2
 * @Date 2019/8/23 20:06
 * @Created by Gangan
 */
public class No17 {

    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] target = new int[n][6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                target[i][j] = scanner.nextInt();
            }
        }

        sum(target,0,n,1,k);

        System.out.println(count);
    }

    public static void sum(int[][] target, int sum, int n, int currentN, int k) {
        if (currentN-1 == n) {
            if (sum == k) {
                count++;
            } else {
                return;
            }

        } else {
            for (int i = 0; i < 6; i++) {
                sum(target, sum + target[currentN-1][i], n, currentN + 1, k);
            }
        }
    }

}
