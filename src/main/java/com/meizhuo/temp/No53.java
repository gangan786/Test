package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No53
 * @Description 环形赛道小游戏
 * @Date 2019/9/21 19:42
 * @Created by Gangan
 */
public class No53 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] points = new int[count];
        for (int i = 0; i < points.length; i++) {
            points[i] = scanner.nextInt();
        }
        if (count == 1) {
            System.out.println(points[0]);
        } else {

            int result = points[0];
            for (int leftIndex = 0; leftIndex < points.length; leftIndex++) {
                int temp = points[leftIndex];

                for (int rightIndex = (leftIndex + 1) % points.length; rightIndex != leftIndex; ) {
                    temp += points[rightIndex];
                    result = Math.max(temp, result);
                    rightIndex++;
                    rightIndex = rightIndex % points.length;
                }
            }
            System.out.println(result);
        }

    }

}
