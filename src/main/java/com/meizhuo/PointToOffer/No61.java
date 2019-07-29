package com.meizhuo.PointToOffer;

import org.junit.Test;

import java.util.Arrays;


/**
 * @Classname No61
 * @Description 扑克牌中的顺子
 * @Date 2019/7/29 14:04
 * @Created by Gangan
 */
public class No61 {

    @Test
    public void test() {
        int[] target = {3, 4, 5, 1, 0, 0};
        System.out.println(isContinuous(target));
    }

    public boolean isContinuous(int[] target) {

        if (target == null || target.length == 0) {
            return false;
        }
        Arrays.sort(target);

        int countOfZero = 0;
        int need = 0;
        for (int i = 0; i < target.length && target[i] == 0; i++) {
            countOfZero++;
        }

        int small = countOfZero;
        int big = small + 1;

        while (big < target.length) {
            if (target[big] == target[small]) {
                return false;
            }
            need += target[big] - target[small] - 1;
            small = big;
            big++;
        }

        return countOfZero >= need;

    }

}
