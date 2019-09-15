package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No41
 * @Description 小招喵的字符串取模
 * @Date 2019/9/15 21:38
 * @Created by Gangan
 */
public class No41 {

    static long result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] target = scanner.nextLine().toCharArray();
        replace(target, getNextIndex(target, -1));
        System.out.println(result);
    }

    public static void replace(char[] target, int index) {
        if (index == -1) {
            Long value = Long.valueOf(new String(target));
            if (value % 13 == 5) {
                result = (long) (result % (Math.pow(10, 9) + 7)) + 1;
            }
        } else {
            for (int i = 0; i <= 9; i++) {
                target[index] = (char) ('0' + i);
                int nextIndex = getNextIndex(target, index);
                replace(target, nextIndex);
                if (target[index] == '9') {
                    target[index] = '?';
                }
            }
        }

    }

    private static int getNextIndex(char[] target, int index) {
        for (int i = index + 1; i < target.length; i++) {
            if (target[i] == '?') {
                return i;
            }
        }
        return -1;
    }

}
