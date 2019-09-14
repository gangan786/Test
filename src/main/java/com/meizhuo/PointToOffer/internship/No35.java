package com.meizhuo.PointToOffer.internship;

import java.util.Scanner;

/**
 * @Classname No35
 * @Description 未排序正数数组中累加和为给定值的最长子数组的长度
 * @Date 2019/9/14 13:59
 * @Created by Gangan
 */
public class No35 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int k = scanner.nextInt();
        int[] line = new int[count];
        for (int i = 0; i < line.length; i++) {
            line[i] = scanner.nextInt();
        }
        int left = 0;
        int right = 0;
        int sum = line[0];
        int maxLen = 0;
        while (right < line.length) {
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
                sum -= line[left];
                left++;
            } else if (sum > k) {
                sum -= line[left];
                left++;
            } else {
                right++;
                if (right >= line.length) {
                    break;
                }
                sum += line[right];
            }
        }
        System.out.println(maxLen);
    }

}
