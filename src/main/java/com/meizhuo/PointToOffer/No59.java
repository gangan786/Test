package com.meizhuo.PointToOffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname No59
 * @Description 队列的最大值
 * @Date 2019/7/25 14:58
 * @Created by Gangan
 */
public class No59 {

    @Test
    public void test() {
        int[] target = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(maxInWindows(target, 3));
    }

    public ArrayList<Integer> maxInWindows(int[] target, int winSize) {
        if (target == null || target.length < winSize) {
            throw new IllegalArgumentException("参数不合法");
        }

        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < winSize; i++) {
            while (!queue.isEmpty() && target[queue.getLast()] < target[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
        }

        for (int i = winSize; i < target.length; i++) {
            result.add(target[queue.getFirst()]);
            while (!queue.isEmpty() && target[queue.getLast()] < target[i]) {
                queue.removeLast();
            }
            if (!queue.isEmpty() && queue.getFirst() <= (i - winSize)) {
                queue.removeFirst();
            }
            queue.addLast(i);
        }

        result.add(target[queue.getFirst()]);
        return result;

    }

}
