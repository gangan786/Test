package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No38
 * @Description 字符串的排列
 * @Date 2019/7/10 11:48
 * @Created by Gangan
 */
public class No38 {

    @Test
    public void test() {
        permutation("abcd");
    }

    public void permutation(String target) {
        if (target == null) {
            throw new NullPointerException();
        }
        permutation(target.toCharArray(), 0);
    }

    private void permutation(char[] target, int beginIndex) {

        if (beginIndex == target.length) {
            System.out.println(new String(target));
        } else {
            for (int curIndex = beginIndex; curIndex < target.length; curIndex++) {

                char temp = target[curIndex];
                target[curIndex] = target[beginIndex];
                target[beginIndex] = temp;

                permutation(target, beginIndex + 1);

                temp = target[curIndex];
                target[curIndex] = target[beginIndex];
                target[beginIndex] = temp;
            }
        }

    }

}
