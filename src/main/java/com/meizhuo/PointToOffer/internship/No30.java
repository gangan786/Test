package com.meizhuo.PointToOffer.internship;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname No30
 * @Description 不重复打印排序数组中相加和为给定值的所有二元组
 * @Date 2019/9/13 15:34
 * @Created by Gangan
 */
public class No30 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int target = scanner.nextInt();
        int[] animals = new int[count];
        for (int i = 0; i < animals.length; i++) {
            animals[i] = scanner.nextInt();
        }

        int leftIndex = 0;
        int rightIndex = animals.length - 1;
        while (leftIndex < rightIndex) {
            if (animals[leftIndex] + animals[rightIndex] == target) {
                if (leftIndex == 0 || animals[leftIndex] != animals[leftIndex - 1]) {
                    System.out.println(animals[leftIndex] + " " + animals[rightIndex]);
                }
                leftIndex++;
                rightIndex--;
            } else if (animals[leftIndex] + animals[rightIndex] > target) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
    }

}
