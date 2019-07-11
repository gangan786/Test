package com.meizhuo.PointToOffer;

import org.junit.Test;

import java.util.HashSet;

/**
 * @Classname No40
 * @Description 找出最小的K个数
 * @Date 2019/7/11 15:43
 * @Created by Gangan
 */
public class No40 {

    @Test
    public void testGetLeastNum_1() {
        int[] target = {1, 5, 0, 7, 3, 8, 9, 10, 4};
        int[] result = getLeastNum_1(target, 4);
        System.out.println(result);
    }

    public int[] getLeastNum_1(int[] target, int k) {
        if (target == null || k <= 0) {
            throw new RuntimeException();
        }
        int start = 0;
        int length = target.length;
        int end = length - 1;

        //调用快排的
        No39 quickSortTool = new No39();
        int index = quickSortTool.partition(target, length, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = quickSortTool.partition(target, length, start, end);
            }
            if (index < k - 1) {
                start = index + 1;
                index = quickSortTool.partition(target, length, start, end);
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = target[i];
        }
        return result;
    }


}
