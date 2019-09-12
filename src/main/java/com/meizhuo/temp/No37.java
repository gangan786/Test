package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No37
 * @Description 分饼干
 * @Date 2019/9/12 20:50
 * @Created by Gangan
 */
public class No37 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] points = new int[count];
        for (int i = 0; i < points.length; i++) {
            points[i] = scanner.nextInt();
        }

        int[] get = new int[count];
        for (int i = 0; i < get.length; i++) {
            get[i] = 1;
        }

        for (int i = 0; i < points.length; i++) {
            int left = i - 1;
            int right = i + 1;
            if (left >= 0 && right < points.length) {
                if (points[i] >= points[left] && points[i] >= points[right]) {
                    get[i] = Math.max(get[left], get[right]) + 1;
                } else if (points[i] <= points[left] && points[i] <= points[right]) {
                    get[i] = 1;
                } else if (points[i] <= Math.max(points[left], points[right]) && points[i] >= Math.min(points[left], points[right])) {
                    get[i] = Math.min(get[left], get[right]) + 1;
                }
            }
            if (i == 0 && i + 1 < points.length) {
                if (points[i] > points[i + 1]) {
                    get[0] = 2;
                }
            }

            if (i == points.length - 1 && points.length > 1) {
                if (points[i] > points[i - 1]) {
                    get[i] = get[i - 1] + 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < get.length; i++) {
            sum += get[i];
        }

        System.out.println(sum);

    }

}
