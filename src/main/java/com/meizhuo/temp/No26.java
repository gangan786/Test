package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No26
 * @Description 期末总结
 * @Date 2019/9/1 21:31
 * @Created by Gangan
 */
public class No26 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] points = new int[count];
        int maxResult = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            points[i] = scanner.nextInt();
        }

        for (int i = 2; i <= points.length; i++) {
            //i为窗口值
            for (int j = 0; j < points.length; j++) {
                //j为起始点
                int endIndex = j + i;
                if (endIndex >= points.length) {
                    break;
                } else {
                    int result = getResult(points, j, endIndex);
                    maxResult = Math.max(result, maxResult);
                }
            }
        }

        System.out.println(maxResult);

    }

    private static int getResult(int[] target, int startIndex, int endIndex) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += target[i];
            min = Math.min(min, target[i]);
        }
        return sum * min;
    }

}
