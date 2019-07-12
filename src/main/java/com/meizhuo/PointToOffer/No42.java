package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No42
 * @Description 连续子数组的最大值
 * @Date 2019/7/12 15:57
 * @Created by Gangan
 */
public class No42 {

    @Test
    public void test() {
        int[] target = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(findGreatestOfSubArray(target));
    }


    public boolean isValid = false;

    public int findGreatestOfSubArray(int[] target) {
        if (target == null || target.length == 0) {
            isValid = false;
            throw new NullPointerException();
        }
        isValid = true;
        int curSum = 0;
        int maxSum = curSum;
        for (int i = 0; i < target.length; i++) {
            if (curSum <= 0) {
                curSum = target[i];
            }else {
                curSum += target[i];
            }
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }

        return maxSum;
    }

}
