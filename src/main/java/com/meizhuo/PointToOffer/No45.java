package com.meizhuo.PointToOffer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Classname No45
 * @Description 把数组排成最小的数
 * @Date 2019/7/15 21:24
 * @Created by Gangan
 */
public class No45 {

    @Test
    public void test() {
        int[] target = {3, 32, 321};
        int[] minNumber = getMinNumber(target);

    }

    public int[] getMinNumber(int[] target) {

        if (target == null) {
            throw new NullPointerException();
        }

        String[] str = new String[target.length];

        for (int i = 0; i < target.length; i++) {
            str[i] = target[i] + "";
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String first = o1 + o2;
                String second = o2 + o1;
                return first.compareTo(second);
            }
        });

        int[] result = new int[target.length];
        for (int i = 0; i < target.length; i++) {
            result[i] = Integer.valueOf(str[i]);
        }

        return result;
    }

}
