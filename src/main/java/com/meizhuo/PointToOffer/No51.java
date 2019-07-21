package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No51
 * @Description 数组中的逆序对
 * @Date 2019/7/21 14:22
 * @Created by Gangan
 */
public class No51 {

    @Test
    public void test() {
        int[] target = {7, 5, 6, 4};
        System.out.println(inversePairs(target));
    }

    public int inversePairs(int[] target) {

        int[] copy = new int[target.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = target[i];
        }

        return inversePairs(target, copy, 0, target.length - 1);
    }

    private int inversePairs(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        int length = (end - start) / 2;

        int left = inversePairs(copy, data, start, start + length);
        int right = inversePairs(copy, data, start + length + 1, end);

        int i = start + length;
        int j = end;
        int copyIndex = end;
        int count = 0;

        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                count += j - start - length;
                copy[copyIndex--] = data[i--];
            } else {
                copy[copyIndex--] = data[j--];
            }
        }

        for (; i >= start; i--) {
            copy[copyIndex--] = data[i];
        }
        for (; j >= start + length + 1; j--) {
            copy[copyIndex--] = data[j];
        }

        return left + right + count;

    }

}
