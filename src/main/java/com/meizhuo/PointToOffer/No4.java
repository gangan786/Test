package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No4
 * @Description 在升序二维数组中查找
 * @Date 2019/6/22 15:07
 * @Created by Gangan
 */
public class No4 {

    public boolean find(int[][] nums, int target) {
        boolean isFind = false;

        int rows = nums.length;
        int columns = nums[0].length;

        int curRow = 0;
        int curColumns = columns - 1;

        while (curRow < rows && curColumns >= 0) {

            if (nums[curRow][curColumns] == target) {
                isFind = true;
                System.out.println("首次发现的位置为: 第" + (curRow + 1) + "行，第" + (curColumns + 1) + "列");
                break;
            } else if (nums[curRow][curColumns] < target) {
                curRow++;
            } else {
                curColumns--;
            }

        }

        return isFind;
    }

    @Test
    public void test() {
        int[][] test = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        find(test, 15);
    }

}
