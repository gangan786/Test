package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No46
 * @Description 把数字翻译字符串
 * @Date 2019/7/19 11:39
 * @Created by Gangan
 */
public class No46 {

    @Test
    public void test() {
        System.out.println(getTranslationCount("12258"));
    }

    public int getTranslationCount(String target) {
        if (target == null || target.length() == 0) {
            throw new IllegalArgumentException("参数非法");
        }
        char[] chars = target.toCharArray();
        return getTranslationCount(chars);
    }

    private int getTranslationCount(char[] target) {
        int length = target.length;
        int count = 0;
        int[] counts = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            if (i < length - 1) {
                count = counts[i + 1];
            } else {
                count = 1;
            }
            if (i < length - 1) {
                int num1 = target[i] - '0';
                int num2 = target[i + 1] - '0';
                int num3 = num1 * 10 + num2;
                if (num3 >= 10 && num3 <= 25) {
                    if (i < length - 2) {
                        count += counts[i + 2];
                    } else {
                        count += 1;
                    }
                }
            }
            counts[i] = count;

        }
        return counts[0];
    }

}
