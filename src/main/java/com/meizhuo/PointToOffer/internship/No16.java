package com.meizhuo.PointToOffer.internship;

import java.util.Scanner;

/**
 * @Classname No16
 * @Description 双核处理
 * @Date 2019/8/21 11:46
 * @Created by Gangan
 * @Description 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，
 * 假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。n个任务可以按照任意顺序放入CPU进行处理，
 * 现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。
 */
public class No16 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] values = new int[count + 1];
        int sum = 0;
        for (int i = 1; i < values.length; i++) {
            values[i] = scanner.nextInt() / 1024;
            sum += values[i];
        }

        int packageValue = sum / 2;

        int[][] maxValues = new int[count + 1][packageValue + 1];

        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= packageValue; j++) {
                if (values[i] > j) {
                    maxValues[i][j] = maxValues[i - 1][j];
                } else {
                    int yes = maxValues[i - 1][j - values[i]] + values[i];
                    int no = maxValues[i - 1][j];
                    maxValues[i][j] = Math.max(yes, no);
                }
            }
        }

        System.out.println(Math.max(maxValues[count][packageValue], sum - maxValues[count][packageValue]) * 1024);

    }

}
