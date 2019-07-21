package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No50
 * @Description 第一个只出现一次的字符
 * @Date 2019/7/21 10:44
 * @Created by Gangan
 */
public class No50 {

    @Test
    public void test() {
        System.out.println(firstNotRepeatingChar("abcbc"));
    }

    public char firstNotRepeatingChar(String target) {
        char[] targetArray = target.toCharArray();
        int[] charHash = new int[256];
        for (int i = 0; i < targetArray.length; i++) {
               charHash[targetArray[i] - 'a']++;
        }
        for (int i = 0; i < targetArray.length; i++) {
            if (charHash['a' - targetArray[i]] == 1) {
                return targetArray[i];
            }
        }
        return '0';
    }

}
