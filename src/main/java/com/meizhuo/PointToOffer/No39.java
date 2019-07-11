package com.meizhuo.PointToOffer;

import org.junit.Test;

import java.util.Random;

/**
 * @Classname No39
 * @Description 数组中出现次数超过一半的数字
 * @Date 2019/7/10 17:11
 * @Created by Gangan
 */
public class No39 {


    @Test
    public void testQuickSort() {
        int[] data = {8, 6, 1, 3, 2, 9, 7, 5, 4};
        quickSort(data, data.length, 0, data.length - 1);
        System.out.println(data);
    }

    @Test
    public void testFindMoreThanHalf() {
        int[] target = {5, 4, 5, 5, 1, 5, 5, 1, 4, 5, 5, 34, 5, 7, 8, 1};
        System.out.println(findMoreThanHalf_2(target));
    }

    /**
     * 这种方式就称为异类相消法吧
     * 同样是找出重复过半的元素
     * @param target
     * @return
     */
    public int findMoreThanHalf_2(int[] target) {
        if (target == null) {
            throw new NullPointerException();
        }
        int result = target[0];
        int time = 1;
        for (int i = 0; i < target.length; i++) {
            if (time == 0) {
                result=target[i];
            }
            if (target[i] == result) {
                time++;
            } else {
                time--;
            }
        }

        if (check(target, result)) {
            return result;
        } else {
            throw new RuntimeException("数据不正确，没有过半重复数");
        }
    }

    private boolean check(int[] target, int result) {
        int countOfResult = 0;
        for (int i = 0; i < target.length; i++) {
            if (target[i] == result) {
                countOfResult++;
            }
        }
        return countOfResult * 2 >= target.length ;
    }


    /**
     * 借鉴快排的解决思路找出数组中超过一半数目的相同元素
     *
     * @param target
     * @return
     */
    public int findMoreThanHalf_1(int[] target) {
        if (target == null) {
            throw new NullPointerException();
        }
        int start = 0;
        int end = target.length - 1;
        int length = target.length;
        int middle = length >> 1;
        int index = partition(target, length, start, end);
        while (index != middle) {
            if (index > middle) {
                end = index - 1;
                index = partition(target, length, start, end);
            }
            if (index < middle) {
                start = index + 1;
                index = partition(target, length, start, end);
            }
        }
        int result = target[middle];

        if (check(target, result)) {
            return result;
        } else {
            throw new RuntimeException("数据不正确，没有过半重复数");
        }

    }

    public void quickSort(int[] data, int length, int start, int end) {
        if (start == end) {
            return;
        }
        //index所指的数的位置就是他在排序数组中确切的位置
        int index = partition(data, length, start, end);
        if (index > start) {
            quickSort(data, length, start, index - 1);
        }
        if (index < end) {
            quickSort(data, length, index + 1, end);
        }
    }

    /**
     * 将数组以small下标为界，左边的小于data[small],
     * 右边的大于data[small]
     *
     * @param data
     * @param length
     * @param start
     * @param end
     * @return 返回中间边界的下标
     */
    private int partition(int[] data, int length, int start, int end) {
        if (data == null || length <= 0 || start < 0 || end >= length) {
            throw new IllegalArgumentException();
        }

        int index = ((end - start) >> 1) + start;

        int temp = data[index];
        data[index] = data[end];
        data[end] = temp;

        int small = start - 1;
        for (index = start; index < end; index++) {
            if (data[index] <= data[end]) {
                ++small;
                if (small != index) {
                    temp = data[index];
                    data[index] = data[small];
                    data[small] = temp;
                }
            }
        }

        ++small;
        temp = data[small];
        data[small] = data[end];
        data[end] = temp;

        return small;
    }

}
