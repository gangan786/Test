package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No56
 * @Description 数组中数字出现的次数
 * @Date 2019/7/24 11:28
 * @Created by Gangan
 */
public class No56 {

    @Test
    public void test() {
        int[] target = {2, 4, 3, 6, 3, 2, 5, 5};
        findNumAppearOnce(target);
    }

    /**
     * 数组中只出现一次的两个数字
     *
     * @param target
     */
    public void findNumAppearOnce(int[] target) {
        if (target == null) {
            throw new NullPointerException();
        }


        int sum = 0;
        for (int i = 0; i < target.length; i++) {
            sum ^= target[i];
        }
        int first1Index = findFirst1Index(sum);

        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < target.length; i++) {
            if (is1InIndex(target[i], first1Index)) {
                result1 ^= target[i];
            } else {
                result2 ^= target[i];
            }
        }

        System.out.println("两个唯一出现的两个数分别是：" + result1 + ", " + result2);

    }

    private boolean is1InIndex(int num, int first1Index) {
        num = num >> first1Index;
        return (num & 1) == 1;
    }

    private int findFirst1Index(int sum) {
        int index = 0;
        while ((sum & 1) == 0 && index < (4 * 8)) {
            sum >>= 1;
            index++;
        }
        return index;
    }

    @Test
    public void testFindNumAppearOnce3() {
        int[] target = {100, 2, 2, 2, 3, 3, 3};
        System.out.println(findNumAppearOnce3(target));
    }

    public int findNumAppearOnce3(int[] target) {
        int[] sum = new int[32];

        for (int i = 0; i < target.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = target[i] & bitMask;
                if (bit != 0) {
                    sum[j] += 1;
                }
                bitMask <<= 1;
            }
        }

        int result = 0;
        for (int i = 0; i < sum.length; i++) {
            result <<= 1;
            result += sum[i] % 3;
        }

        return result;

    }

}
