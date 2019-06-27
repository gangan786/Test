package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No13
 * @Description 机器人的运动范围
 * @Date 2019/6/27 11:39
 * @Created by Gangan
 */
public class No13 {

    /**
     * 返回机器人所能到达的格子数
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 0 || cols < 0) {
            return 0;
        }
        boolean[] isValid = new boolean[rows * cols];
        int count = 0;
        count = movingCountCode(threshold, isValid, rows, cols, 0, 0);
        return count;
    }

    private int movingCountCode(int threshold, boolean[] isValid, int rows, int cols, int row, int col) {
        int count = 0;
        if (check(isValid, threshold, rows, cols, row, col)) {
            isValid[row * cols + col] = true;
            count = 1 + movingCountCode(threshold, isValid, rows, cols, row + 1, col) +
                    movingCountCode(threshold, isValid, rows, cols, row - 1, col) +
                    movingCountCode(threshold, isValid, rows, cols, row, col + 1) +
                    movingCountCode(threshold, isValid, rows, cols, row, col - 1);
        }
        return count;
    }

    private boolean check(boolean[] isValid, int threshold, int rows, int cols, int row, int col) {
        if (row < rows && row >= 0 && col < cols && col >= 0
                && (sum(row) + sum(col)) <= threshold
                && !isValid[row * cols + col]) {
            return true;
        }
        return false;
    }

    private int sum(int num) {
        int sum=0;
        while (num > 0) {
            sum=num%10;
            num/=10;
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(movingCount(2, 3, 4));
    }

}
