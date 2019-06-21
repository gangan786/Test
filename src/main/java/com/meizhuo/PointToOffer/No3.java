package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No3
 * @Description 找出重复的数字
 * @Date 2019/6/20 16:01
 * @Created by Gangan
 */
public class No3 {

    public boolean duplicate(int[] valus) {
        if (valus == null || valus.length == 0) {
            return false;
        }
        for (int i = 0; i < valus.length; i++) {
            if (valus[i] < 0 || valus[i] > valus.length - 1) {
                return false;
            }
        }

        for (int i = 0; i < valus.length; i++) {

            while (i != valus[i]) {
                if (valus[valus[i]] != valus[i]) {
                    int temp = valus[valus[i]];
                    valus[valus[i]] = valus[i];
                    valus[i] = temp;
                } else {
                    System.out.println("其中一个重复数字为：" + valus[i]);
                    return true;
                }
            }

        }

        System.out.println("没有重复数字");
        return false;
    }

    public int halfDuplicate(int[] values) {
        int start = 1;
        int end = values.length - 1;
        while (start <= end) {
            int mid = ((end - start) >> 1) + start;
            int count = countElm(values, start, mid);

            if (start == end) {
                if (count > 1) {
                    //找到重复的一个数字
                    return start;
                } else {
                    return -1;
                }
            }

            if (count == (mid - start + 1)) {
                start = mid + 1;
            } else {
                end = mid;
            }

        }
        return -1;
    }

    private int countElm(int[] values, int start, int mid) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] >= start && values[i] <= mid) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        int[] ints = {2, 6, 1, 0, 4, 5, 3};
        int[] halfTest = {2, 1, 5, 4, 3, 2, 6, 7};
        System.out.println("结果为：" + halfDuplicate(halfTest));
    }

}
