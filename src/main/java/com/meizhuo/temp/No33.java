package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No33
 * @Description 数组移动
 * @Date 2019/9/11 19:26
 * @Created by Gangan
 */
public class No33 {

    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int minSum = Integer.MAX_VALUE;
    static int minCount = Integer.MAX_VALUE;

    static void solution(int[] arr) {

        resever(arr, 0, 0);

    }

    private static void resever(int[] arr, int beginIndex, int count) {
        if (beginIndex == arr.length) {

            int sum = 0;

            for (int i = 0; i < arr.length - 1; i++) {
                sum += Math.abs(arr[i] - arr[i + 1]);
            }
            if (sum < minSum) {
                minSum = sum;
                minCount = count;
            }

        } else {
            for (int i = beginIndex; i < arr.length; i++) {
                int temp = arr[beginIndex];
                arr[beginIndex] = arr[i];
                arr[i] = temp;

                resever(arr, beginIndex + 1, arr[beginIndex] == arr[i] ? count : count + 1);

                temp = arr[beginIndex];
                arr[beginIndex] = arr[i];
                arr[i] = temp;
            }
        }

    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for (int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        solution(_arr);
        System.out.println(String.valueOf(minCount));

    }

}
