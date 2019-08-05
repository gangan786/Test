package com.meizhuo.temp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Classname No4
 * @Description TODO
 * @Date 2019/8/3 16:04
 * @Created by Gangan
 */
public class No4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfNum = scanner.nextInt();
        int countOfOper = scanner.nextInt();
        int[] nums = new int[countOfNum];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);

        while (countOfOper != 0) {
            int targetNum = scanner.nextInt();
            int targetIndex = findIndex(targetNum, nums, 0, nums.length - 1);
            int countOfInfect = 0;
            for (int i = targetIndex; i <nums.length; i++) {
                nums[i]--;
                countOfInfect++;
            }
            System.out.println(countOfInfect);
            countOfOper--;
        }
    }

    private static int findIndex(int targetNum, int[] nums, int start, int end) {

        while (start < end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] > targetNum) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        if (start == end) {
            return start;
        } else {
            return -1;
        }

    }

}
