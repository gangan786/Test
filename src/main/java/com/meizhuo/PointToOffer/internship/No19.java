package com.meizhuo.PointToOffer.internship;

import java.util.Scanner;

/**
 * @Classname No19
 * @Description 获得最多奖金
 * @Date 2019/8/22 11:55
 * @Created by Gangan
 */
public class No19 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] values = new int[count];
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }

        long max = 0;

        int leftIndex = 0;
        int rightIndex = count - 1;
        int leftValue = values[leftIndex];
        int rightValue = values[rightIndex];

        while (leftIndex < rightIndex) {

            if (leftValue < rightValue) {
                leftIndex++;
                leftValue += values[leftIndex];
            } else if (leftValue == rightValue) {
                max = leftValue;
                leftIndex++;
                rightIndex--;
                leftValue += values[leftIndex];
                rightValue += values[rightIndex];
            } else {
                rightIndex--;
                rightValue += values[rightIndex];
            }
        }

        System.out.println(max);

    }

}
