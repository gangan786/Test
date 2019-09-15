package com.meizhuo.PointToOffer.internship;

import java.util.Scanner;

/**
 * @Classname No41
 * @Description 未排序数组中累加和小于或等于给定值的最长子数组长度
 * @Date 2019/9/15 16:07
 * @Created by Gangan
 */
public class No41 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[count];
        int[] leftMax = new int[count + 1];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
            leftMax[i + 1] = Math.max(sum, leftMax[i]);
        }
        sum = 0;
        int result = 0;
        int pre = 0;
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            pre = getLessIndex(leftMax, sum - k);
            len = pre == -1 ? 0 : i - pre + 1;
            result = Math.max(result, len);
        }
        System.out.println(result);
    }

    private static int getLessIndex(int[] leftMax, int num) {
        int low = 0;
        int height = leftMax.length - 1;
        int mid = 0;
        int resIndex = -1;
        while (low <= height) {
            mid = (low + height) / 2;
            if (leftMax[mid] >= num) {
                resIndex = mid;
                height = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return resIndex;
    }

}
