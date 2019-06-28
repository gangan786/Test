package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No15
 * @Description 二进制中1的个数
 * @Date 2019/6/28 14:28
 * @Created by Gangan
 */
public class No15 {

    /**
     * 此种实现会导致当参数小于0时会出现死循环
     *
     * @param target
     * @return
     */
    public int numOfOne_1(int target) {
        int count = 0;
        while (target > 0) {
            if ((target & 1) == 1) {
                count++;
            }
            target >>= 1;
        }
        return count;
    }

    /**
     * 时间复杂度取决于target的位数
     *
     * @param target
     * @return
     */
    public int numOfOne_2(int target) {
        int count = 0;
        int point = 1;
        while (point != 0) {
            if ((target & point) == point) {
                count++;
            }
            //当point左移32位之后就变成 0
            point <<= 1;
        }
        return count;
    }

    /**
     * 优化解法
     * 时间复杂度为target中1的个数
     *
     * @param target
     * @return
     */
    public int numOfOne_3(int target) {
        int count = 0;
        while (target != 0) {
            count++;
            target = (target - 1) & target;
        }
        return count;
    }


    @Test
    public void test() {
        System.out.println(numOfOne_1(8));
        System.out.println(numOfOne_2(-15));
        System.out.println(numOfOne_3(-15));
    }

}
