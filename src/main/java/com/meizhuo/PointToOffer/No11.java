package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No11
 * @Description 在旋转数组中查找最小数
 * @Date 2019/6/25 15:32
 * @Created by Gangan
 */
public class No11 {

    public int findTarget(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = start;
        while (nums[start] >= nums[end]) {
            if (end - start == 1) {
                mid = end;
                return mid;
            }
            mid = (start + end) / 2;
            if (nums[start] == nums[end]
                    && nums[start] == nums[end]) {
                return minInOrder(nums, start, end);
            } else if (nums[mid] >= nums[start]) {
                start = mid;
            } else if (nums[mid] <= nums[end]) {
                end = mid;
            }
        }
        return mid;
    }

    private int minInOrder(int[] nums, int start, int end) {
        int min = nums[start];
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    @Test
    public void test() {
        int[] nums=new int[]{3,4,5,1,2};
        System.out.println("结果为：" + findTarget(nums));
    }

}
