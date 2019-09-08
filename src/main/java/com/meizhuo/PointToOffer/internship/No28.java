package com.meizhuo.PointToOffer.internship;

import java.util.Scanner;

/**
 * @Classname No28
 * @Description 最长回文子串和最长回文子序列
 * @Date 2019/9/8 21:37
 * @Created by Gangan
 */
public class No28 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.next();
        System.out.println(getLPS_2(target));
    }


    /**
     * 获取最大回文子串
     * @param target
     */
    public static void getLPS(String target) {
        int maxLength = 1;
        int start=0;
        char[] chars = target.toCharArray();
        int length = chars.length;
        boolean[][] isLPS = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (i - j < 2) {
                    isLPS[j][i] = chars[i] == chars[j];
                } else {
                    isLPS[j][i] = isLPS[j + 1][i - 1] && chars[i] == chars[j];
                }

                if (isLPS[j][i]&&i - j + 1 > maxLength) {
                    maxLength = i - j + 1;
                    start=j;
                }

            }
        }

        System.out.println(maxLength);
        System.out.println(target.substring(start, start + maxLength));
    }

    /**
     * 最长回文子序列
     * @param s
     * @return
     */
    public static int getLPS_2(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        // 第一维参数表示起始位置的坐标，第二维参数表示长度，使用 0 表示长度 1
        int[][] lps = new int[length][length];
        for (int i = 0; i < length; i++) {
            lps[i][i] = 1;
            // 单个字符的最长回文子序列长度为1，特殊对待一下
        }
        // (i + 1) 表示当前循环的子字符串长度
        for (int i = 1; i < length; i++) {
            // j 表示当前循环的字符串起始坐标
            for (int j = 0; i + j < length; j++) {
                // 即当前循环的子字符串坐标为 [j, i + j]
                // 所以第一个字符是 chars[j]，最后一个字符就是 chars[i + j]
                if (chars[j] == chars[i + j]) {
                    lps[j][i + j] = lps[j + 1][i + j - 1] + 2;
                } else {
                    lps[j][i + j] = Math.max(lps[j][i + j - 1], lps[j + 1][i + j]);
                }
            }
        }
        // 最大值一定在以0为起始点，长度为 length - 1 的位置
        return lps[0][length - 1];
    }

}
