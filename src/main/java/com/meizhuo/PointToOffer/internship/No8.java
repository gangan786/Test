package com.meizhuo.PointToOffer.internship;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname No8
 * @Description 最迟闹钟起床
 * @Date 2019/8/16 17:02
 * @Created by Gangan
 */
public class No8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfClock = scanner.nextInt();
        int[] clocks = new int[numOfClock];
        for (int i = 0; i < clocks.length; i++) {
            int hour = scanner.nextInt();
            int minute = scanner.nextInt();
            clocks[i] = hour * 60 + minute;
        }

        int sum = scanner.nextInt();
        int schoolHour = scanner.nextInt();
        int schoolMinute = scanner.nextInt();
        int max = schoolHour * 60 + schoolMinute - sum;
        Arrays.sort(clocks);
        int point = Arrays.binarySearch(clocks, max);
        if (point < 0) {
            point=-(point+2);
        }
        System.out.println(clocks[point] / 60 + " " + clocks[point] % 60);
    }


    public static void v2() {
        Scanner scanner = new Scanner(System.in);
        int numOfClock = scanner.nextInt();
        int[] clocks = new int[numOfClock];
        for (int i = 0; i < clocks.length; i++) {
            int hour = scanner.nextInt();
            int minute = scanner.nextInt();
            clocks[i] = hour * 60 + minute;
        }

        int sum = scanner.nextInt();
        int schoolHour = scanner.nextInt();
        int schoolMinute = scanner.nextInt();
        int max = schoolHour * 60 + schoolMinute - sum;
        int point=0;

        for (int i = 0; i < clocks.length; i++) {
            if (clocks[i] <= max) {
                if (clocks[i] >= clocks[point]) {
                    point=i;
                }
            }
        }

        System.out.println(clocks[point] / 60 + " " + clocks[point] % 60);
    }

}
