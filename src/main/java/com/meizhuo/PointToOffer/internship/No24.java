package com.meizhuo.PointToOffer.internship;

import java.util.Scanner;

/**
 * @Classname No24
 * @Description 魔法深渊
 * @Date 2019/8/29 14:06
 * @Created by Gangan
 */
public class No24 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] targets = new int[count];
        int maxCount = 0;
        for (int i = 0; i < targets.length; i++) {
            targets[i] = scanner.nextInt();
            maxCount = Math.max(targets[i], maxCount);
        }

        //构建
        long[] results = new long[maxCount + 1];
        results[0] = 1;
        results[1] = 1;
        results[2] = 2;

        for (int i = 3; i < results.length; i++) {
            int a = (int) (Math.log(i) / Math.log(2));
            for (int j = 0; j <= a; j++) {
                int available= (int) Math.pow(2,j);
                int index = i - available;
                results[i] += results[index];
                //为了防止溢出对结果用10^9 + 3取模运算
                results[i]%=(Math.pow(10,9)+3);
            }
        }

        for (int i = 0; i < targets.length; i++) {
            //台阶数
            System.out.println(results[targets[i]]);
        }

    }

}
