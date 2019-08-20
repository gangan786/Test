package com.meizhuo.PointToOffer.internship;

import java.util.Arrays;
import java.util.Scanner;


/**
 * @Classname No14
 * @Description 表达式求值
 * @Date 2019/8/20 14:05
 * @Created by Gangan
 */
public class No14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(max(a, b, c));

    }

    public static int max(int a, int b, int c) {
        return Math.max(Math.max(max2(max2(a, b), c), max2(max2(a, c), b)), max2(max2(b, c), a));
    }

    public static int max2(int a, int b) {
        return Math.max(a + b, a * b);
    }

    public static int max3(int a, int b, int c) {
        int[] ints = {a, b, c};
        Arrays.sort(ints);
        if (ints[0] <= 1) {
            return ints[0] + ints[1] * ints[2];
        } else {
            return ints[0] * ints[1] * ints[2];
        }
    }

}
