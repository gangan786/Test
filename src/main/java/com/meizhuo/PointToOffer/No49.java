package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No49
 * @Description 查找第n个丑数
 * @Date 2019/7/20 14:19
 * @Created by Gangan
 */
public class No49 {



    @Test
    public void test() {
        System.out.println(isUgly(25));
        System.out.println(getUglyNumber(15));
        System.out.println(getUglyNumber_2(15));
    }

    private boolean isUgly(int target) {
        if (target == 0) {
            return false;
        }
        while (target % 2 == 0) {
            target /= 2;
        }
        while (target % 3 == 0) {
            target /= 3;
        }
        while (target % 5 == 0) {
            target /= 5;
        }
        return target == 1;
    }

    public int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }

        int number = 0;
        int uglyIndex = 0;
        while (uglyIndex < index) {
            number++;
            if (isUgly(number)) {
                uglyIndex++;
            }
        }

        return number;
    }


    public int getUglyNumber_2(int index) {
        int[] uglys = new int[index];
        uglys[0] = 1;
        int nextUgly = 1;

        int borderOf2 = 0;
        int borderOf3 = 0;
        int borderOf5 = 0;

        while (nextUgly < index) {
            uglys[nextUgly] = minInThree(
                    uglys[borderOf2] * 2,
                    uglys[borderOf3] * 3,
                    uglys[borderOf5] * 5);
            while (uglys[borderOf2] * 2 <= uglys[nextUgly]) {
                borderOf2++;
            }
            while (uglys[borderOf3] * 3 <= uglys[nextUgly]) {
                borderOf3++;
            }
            while (uglys[borderOf5] * 5 <= uglys[nextUgly]) {
                borderOf5++;
            }
            nextUgly++;
        }

        return uglys[nextUgly - 1];
    }

    private int minInThree(int i, int i1, int i2) {
        return Integer.min(i2, Integer.min(i, i1));
    }


}
