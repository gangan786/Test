package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No14
 * @Description 剪绳子
 * @Date 2019/6/27 14:35
 * @Created by Gangan
 */
public class No14 {

    /**
     * 求解绳子的最大乘积（动态规划）
     * @param length
     * @return
     */
    public int maxProductCutting(int length) {
        if (length <2) {
            return 0;
        } else if (length == 2) {
            return 1;
        } else if (length == 3) {
            return 2;
        }

        int[] values = new int[length + 1];
        values[0]=0;
        values[1]=1;
        values[2]=2;
        values[3]=3;

        for (int i = 4; i < length + 1; i++) {
            int max=0;
            for (int j = 1; j <= i/2; j++) {
                int value=values[j] * values[i - j];
                if (max <value) {
                    max=value;
                }
            }
            values[i]=max;
        }

        return values[length];
    }

    /**
     * 贪婪算法求解
     * @param length
     * @return
     */
    public int maxProductAfterCutting(int length) {
        if (length <2) {
            return 0;
        } else if (length == 2) {
            return 1;
        } else if (length == 3) {
            return 2;
        }
        int timesOf3=length/3;
        if (length - timesOf3 * 3 == 1) {
            timesOf3--;
        }
        int timesOf2=(length-timesOf3*3)/2;
        return (int) (Math.pow(3,timesOf3)*Math.pow(2,timesOf2));
    }

    @Test
    public void test() {
        System.out.println(maxProductCutting(12));
        System.out.println(maxProductAfterCutting(12));
    }

}
