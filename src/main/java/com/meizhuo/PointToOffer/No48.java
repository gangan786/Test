package com.meizhuo.PointToOffer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Classname No48
 * @Description 最长不含重复字符的子字符串
 * @Date 2019/7/20 10:42
 * @Created by Gangan
 */
public class No48 {

    @Test
    public void test() {
        System.out.println(longestSubstringWithoutDuplication("arabcacfr"));
    }

    public int longestSubstringWithoutDuplication(String target) {
        char[] targetChars = target.toCharArray();
        int curLength = 0;
        int maxLength = 0;
        int[] positions = new int[26];
        for (int i = 0; i < positions.length; i++) {
            positions[i] = -1;
        }



        for (int i = 0; i < targetChars.length; i++) {
            int preIndex = positions[targetChars[i] - 'a'];
            if (preIndex < 0 || i - preIndex > curLength) {
                curLength++;
            } else {
                if (curLength >= maxLength) {
                    maxLength = curLength;
                }
                // i - preIndex <= curLength
                curLength = i - preIndex;
            }
            positions[targetChars[i] - 'a'] = i;
        }
        if (curLength > maxLength) {
            maxLength = curLength;
        }

        return maxLength;
    }

}
