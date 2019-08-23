package com.meizhuo.PointToOffer.internship;

import org.junit.Test;

/**
 * @Classname No23
 * @Description 动态规划查找最长子串
 * @Date 2019/8/23 17:07
 * @Created by Gangan
 */
public class No23 {

    public int LIS(int[] target) {
        int length = target.length;
        int maxCount = 0;

        int[] dp = new int[length];

        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (target[i] > target[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxCount = Math.max(maxCount, dp[i]);
        }

        return maxCount;

    }

    @Test
    public void test() {
        int[] target = {-3, 1, 3, 6, -1, 2, -3, 4, -5, 6, -7, 7};
        System.out.println(LIS(target));
    }

}
