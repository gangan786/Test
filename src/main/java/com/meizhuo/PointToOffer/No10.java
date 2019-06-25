package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No10
 * @Description 斐波那契数列
 * @Date 2019/6/25 11:43
 * @Created by Gangan
 */
public class No10 {

    public int fibonacci(int target) {
        if (target == 1) {
            return 0;
        } else if (target == 2) {
            return 1;
        } else if (target > 2) {
            int[] results = new int[target];
            results[0] = 0;
            results[1] = 1;
            int resultFront = results[0];
            int resultBack = results[1];
            for (int i = 2; i < target; i++) {
                results[i] = resultFront + resultBack;
                resultFront = resultBack;
                resultBack = results[i];
            }
            return results[target-1];
        }
        return -1;

    }

    @Test
    public void test() {
        System.out.println("结果：" + fibonacci(10));
    }

}
