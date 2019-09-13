package com.meizhuo.PointToOffer.internship;

import java.util.Scanner;

/**
 * @Classname No31
 * @Description 不重复打印排序数组中相加和为给定值的所有三元组
 * @Date 2019/9/13 16:58
 * @Created by Gangan
 */
public class No31 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int target = scanner.nextInt();
        int[] animals = new int[count];
        for (int i = 0; i < animals.length; i++) {
            animals[i] = scanner.nextInt();
        }

        for (int i = 0; i < animals.length; i++) {
            if (i == 0 || animals[i] != animals[i - 1]) {
                findTwo(animals,animals[i],i+1,animals.length-1,target);
            }
        }

    }

    public static void findTwo(int[] animals,int firstNum, int beginIndex, int endIndex, int target) {
        int leftIndex=beginIndex;
        int rightIndex=endIndex;
        while (leftIndex < rightIndex) {
            if (target - firstNum == animals[leftIndex] + animals[rightIndex]) {
                if (leftIndex == 0 || animals[leftIndex] != animals[leftIndex - 1]) {
                    System.out.println(firstNum + " " + animals[leftIndex] + " " + animals[rightIndex]);
                }
                leftIndex++;
                rightIndex--;
            } else if (target - firstNum > animals[leftIndex] + animals[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
    }

}
