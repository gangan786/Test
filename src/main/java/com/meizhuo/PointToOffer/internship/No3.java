package com.meizhuo.PointToOffer.internship;

import java.util.Scanner;

/**
 * @Classname No3
 * @Description 被3整除
 * @Date 2019/8/6 16:59
 * @Created by Gangan
 */
public class No3 {

    public static void main(String[] args) {
        //v1();
        //v2();
        v3();
    }

    /**
     * 算法错误
     */
    public static void v1() {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int result = 0;

        for (int i = start; i <= end; i++) {
            long sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += j;
            }
            if ((sum % 3) == 0) {
                result++;
            }
        }

        System.out.println(result);

    }

    public static void v2() {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int result = 0;
        StringBuilder num = new StringBuilder();

        for (int i = start; i <= end; i++) {
            for (int j = 1; j <= i; j++) {
                    num.append(j);
            }
            long sum = getSum(num);
            if (sum % 3 == 0) {
                result++;
            }
            num.delete(0, num.length());
        }

        System.out.println(result);

    }


    public static long getSum(StringBuilder target) {
        long sum = 0;
        for (int i = 0; i < target.length(); i++) {
            sum += target.charAt(i) - '0';
        }
        return sum;
    }

    public static void v3() {
        Scanner scanner = new Scanner(System.in);
        int left = scanner.nextInt();
        int right = scanner.nextInt();

        System.out.println(right - left + 1 - (getUnfitCount(right) - getUnfitCount(left)));
    }

    private static int getUnfitCount(int bound) {
        return (bound + 2) / 3;
    }


}
