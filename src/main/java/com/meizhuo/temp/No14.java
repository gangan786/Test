package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No14
 * @Description 背包最大价值
 * @Date 2019/8/20 19:45
 * @Created by Gangan
 */
public class No14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] weights = new int[count+1];
        int[] values = new int[count+1];
        weights[0]=0;
        values[0]=0;
        for (int i = 1; i < weights.length; i++) {
            weights[i]=scanner.nextInt();
        }
        for (int i = 1; i < values.length; i++) {
            values[i]=scanner.nextInt();
        }
        int maxWeight = scanner.nextInt();

        int[][] maxValue = new int[count + 1][maxWeight + 1];

        for (int i = 1; i < count + 1; i++) {
            for (int j = 1; j < maxWeight + 1; j++) {
                if (weights[i] > j) {
                    maxValue[i][j] = maxValue[i - 1][j];
                } else {
                    maxValue[i][j]=Math.max(maxValue[i-1][j-weights[i]]+values[i],maxValue[i-1][j]);
                }
            }
        }

    }

}
