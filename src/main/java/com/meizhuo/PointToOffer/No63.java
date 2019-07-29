package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No63
 * @Description 股票的最大利润
 * @Date 2019/7/29 15:29
 * @Created by Gangan
 */
public class No63 {

    @Test
    public void test() {
        int[] target = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(maxDiff(target));
    }

    public int maxDiff(int[] prices) {
        if (prices == null || prices.length < 2) {
            return -1;
        }
       int min=prices[0];
       int maxDiff=prices[1]-prices[0];

        for (int i = 2; i < prices.length; i++) {
            if (prices[i - 1] < min) {
                min=prices[i-1];
            }
            if (maxDiff < prices[i] - min) {
                maxDiff=prices[i]-min;
            }
        }

        return maxDiff;
    }

}
