package com.meizhuo.temp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname No44
 * @Description 落单的数
 * @Date 2019/9/18 21:10
 * @Created by Gangan
 */
public class No44 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] points = new int[count];
        for (int i = 0; i < points.length; i++) {
            points[i] = scanner.nextInt();
        }
        Arrays.sort(points);
        for (int i = 0; i < points.length; i += 2) {
            if (i != points.length - 1) {
                if (points[i] != points[i + 1]) {
                    System.out.println(points[i]);
                    break;
                }
            } else {
                System.out.println(points[i]);
            }
        }
    }

}
