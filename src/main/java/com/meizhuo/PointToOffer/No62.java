package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No62
 * @Description 圆圈中最后剩下额数字
 * @Date 2019/7/29 15:10
 * @Created by Gangan
 */
public class No62 {

    @Test
    public void test() {
        System.out.println(lastRemaining(5, 3));
    }

    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        int last=0;
        for (int i = 2; i <= n; i++) {
            last=(last+m)%i;
        }

        return last;
    }

}
