package com.meizhuo.PointToOffer.internship;

import java.util.Scanner;

/**
 * @Classname No11
 * @Description 瞌睡
 * @Date 2019/8/17 16:02
 * @Created by Gangan
 */
public class No11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int classLength = scanner.nextInt();
        int clearLength = scanner.nextInt();
        int[] funList = new int[classLength];
        int[] isClearList = new int[classLength];
        for (int i = 0; i < classLength; i++) {
            funList[i] = scanner.nextInt();
        }
        for (int i = 0; i < classLength; i++) {
            isClearList[i] = scanner.nextInt();
        }

        int base = 0;
        int max = 0;
        for (int i = 0; i < funList.length; i++) {
            if (isClearList[i] == 1) {
                base += funList[i];
            } else {
                int temp = 0;
                for (int j = 0; j < clearLength; j++) {
                    //对叫醒后的最大兴趣值进行筛选
                    int index = i + j;
                    if (index < funList.length && isClearList[index] == 0) {
                        temp += funList[index];
                    }
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }

        System.out.println(base + max);

    }

}
