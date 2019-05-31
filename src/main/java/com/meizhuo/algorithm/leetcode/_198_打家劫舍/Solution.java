package com.meizhuo.algorithm.leetcode._198_打家劫舍;

/**
 * @Classname Solution
 * @Description 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * @Date 2019/4/24 21:48
 * @Created by Gangan
 */
public class Solution {

    private static int[] memo;

    /**
     * 递归＋记忆
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        memo = new int[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return tryRob(nums, 0);
    }

    private int tryRob(int[] nums, int index) {

        if (index >= nums.length) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }
        memo[index] = res;

        return res;
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] memo = new int[n];
        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }
        return memo[0];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 0, 0, 7, 5, 3, 8, 9, 8, 0, 7};
        System.out.println(new Solution().rob2(nums));
    }

}
