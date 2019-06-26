package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No12
 * @Description 判断一个矩阵中是否存在一条包含某个字符串所有字符的路径
 * @Date 2019/6/26 16:00
 * @Created by Gangan
 */
public class No12 {

    public boolean isExit(char[] matrixChar, int rows, int cols, char[] target) {
        int pathLength = 0;
        boolean[] isValid = new boolean[rows * cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPath(matrixChar, row, col, rows, cols, target, pathLength, isValid)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPath(char[] matrixChar, int row, int col,
                            int rows, int cols,
                            char[] target, int pathLength, boolean[] isValid) {
        if (pathLength == target.length) {
            return true;
        }
        boolean isFind = false;
        if (row < rows && row >= 0 &&
                col < cols && col >= 0 &&
                matrixChar[row * cols + col] == target[pathLength] &&
                !isValid[row * cols + col]) {
            pathLength++;
            isValid[row * cols + col] = true;
            isFind = (hasPath(matrixChar, row - 1, col, rows, cols, target, pathLength, isValid) ||
                    hasPath(matrixChar, row + 1, col, rows, cols, target, pathLength, isValid) ||
                    hasPath(matrixChar, row, col + 1, rows, cols, target, pathLength, isValid) ||
                    hasPath(matrixChar, row, col - 1, rows, cols, target, pathLength, isValid));
            if (!isFind) {
                pathLength--;
                isValid[row * cols + col] = false;
            }

        }
        return isFind;
    }

    @Test
    public void test() {
        char[] matrixChar = new char[]{'a', 'b', 't', 'g',
                'c', 'f', 'c', 's',
                'j', 'd', 'e', 'h'};
        char[] target = new char[]{'t', 'c', 'e', 'h'};
        System.out.println(isExit(matrixChar, 3, 4, target));
    }

}
