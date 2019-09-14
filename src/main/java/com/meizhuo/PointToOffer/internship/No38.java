package com.meizhuo.PointToOffer.internship;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Classname No38
 * @Description 未排序数组中累加和为给定值的最长子数组系列问题补2
 * @Date 2019/9/14 16:29
 * @Created by Gangan
 */
public class No38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int k = 0;
        int[] line = new int[count];
        for (int i = 0; i < line.length; i++) {
            int target = scanner.nextInt();
            if (target == 0) {
                line[i] = -1;
            } else {
                line[i] = 1;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        map.put(0, -1);
        for (int i = 0; i < line.length; i++) {
            sum += line[i];
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        System.out.println(maxLen);

    }
}
