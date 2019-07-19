package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No47
 * @Description 礼物的最大值
 * @Date 2019/7/19 14:40
 * @Created by Gangan
 */
public class No47 {

    @Test
    public void test() {
        int[][] map = {{1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}};
        System.out.println(getMaxValue(map));
    }

    public int getMaxValue(int[][] map) {

        if (map == null || map.length == 0) {
            throw new IllegalArgumentException("参数非法");
        }

        int rows = map.length;
        int cols = map[0].length;

        int[] maxValues = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int up = 0;
                int right = 0;
                if (i > 0) {
                    up = maxValues[j];
                }
                if (j > 0) {
                    right = maxValues[j - 1];
                }
                maxValues[j] = Integer.max(up, right) + map[i][j];

            }
        }

        return maxValues[cols - 1];

    }

}
