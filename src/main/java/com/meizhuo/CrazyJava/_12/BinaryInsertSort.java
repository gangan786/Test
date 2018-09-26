package com.meizhuo.CrazyJava._12;

import java.util.Arrays;

public class BinaryInsertSort {
    public static void binaryInsertSort(DataWrap[] data) {
        System.out.println("开始排序");
        int arrayLength = data.length;
        for (int i = 1; i < arrayLength; i++) {
            //当整体后移时，保证data[i]的值不会丢失
            DataWrap tmp = data[i];
            int low = 0;
            int height = i - 1;
            while (low <= height) {
                //找出low，height中间索引
                int mid = (low + height) / 2;
                //如果tmp值大于low，height中间元素的值
                if (tmp.compareTo(data[mid]) > 0) {
                    //限制在索引大于mid的那一半搜索
                    low = mid + 1;
                } else {
                    //限制在索引小于mid的那一半搜索
                    height = mid - 1;
                }
            }
            //将low到i处的所有元素向后整移一位
            for (int j = i; j > low; j--) {
                data[j] = data[j - 1];
            }
            //最后将tmp插到合适位置
            data[low] = tmp;
            System.out.println(Arrays.toString(data));
        }
    }

    public static void main(String[] args) {
        DataWrap data[] = {
                new DataWrap(9, ""),
                new DataWrap(-16, ""),
                new DataWrap(21, "*"),
                new DataWrap(23, ""),
                new DataWrap(-30, ""),
                new DataWrap(-49, ""),
                new DataWrap(21, ""),
                new DataWrap(30, "*"),
                new DataWrap(30, ""),
        };
        System.out.println("排序之前：" + Arrays.toString(data));
        binaryInsertSort(data);
        System.out.println("排序之后：" + Arrays.toString(data));
    }
}
