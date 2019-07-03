package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No29
 * @Description 顺时钟打印矩阵
 * @Date 2019/7/3 9:19
 * @Created by Gangan
 */
public class No29 {

    @Test
    public void test() {
        int[][] target = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        printMatrix(target);
    }

    public void printMatrix(int[][] target) {

        if (target == null || target[0] == null) {
            throw new NullPointerException("参数非法");
        }
        int rows = target.length;
        int columns = target[0].length;
        int start = 0;
        while (start * 2 < rows && 2 * start < columns) {
            printMatrixCycle(target, start);
            start++;
        }

    }

    private void printMatrixCycle(int[][] target, int start) {

        int endX = target[0].length - 1 - start;
        int endY = target.length - 1 - start;

        //向右打印一行
        for (int i = start; i <= endX; i++) {
            System.out.println(target[start][i]);
        }
        //向下打印一列
        if (endY > start) {
            for (int i = start + 1; i <= endY; i++) {
                System.out.println(target[i][endX]);
            }
        }
        //向左打印一行
        if (endY > start && endX > start) {
            for (int i = endX - 1; i >= start; i--) {
                System.out.println(target[endY][i]);
            }
        }

        //向上打印一列
        if (endY - start > 1 && endX > start) {
            for (int i = endY - 1; i > start; i--) {
                System.out.println(target[i][start]);
            }
        }

    }

}
