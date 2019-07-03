package com.meizhuo.PointToOffer;

import org.junit.Test;

import java.util.Stack;

/**
 * @Classname No31
 * @Description 栈的压入，弹出序列
 * @Date 2019/7/3 16:31
 * @Created by Gangan
 */
public class No31 {

    @Test
    public void test() {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
        System.out.println(isPopOrder(push, pop));
    }

    public boolean isPopOrder(int[] push, int[] pop) {
        boolean isPopOrder = false;
        int pushIndex = 0;
        int popIndex = 0;
        if (push != null && pop != null && push.length == pop.length) {

            Stack<Integer> stack = new Stack<>();

            while (pop.length > popIndex) {

                while (stack.isEmpty() || stack.peek() != pop[popIndex]) {
                    if (pushIndex == push.length) {
                        break;
                    }
                    stack.push(push[pushIndex]);
                    pushIndex++;
                }

                if (stack.peek() == pop[popIndex]) {
                    stack.pop();
                    popIndex++;
                } else {
                    break;
                }
            }
            if (stack.isEmpty() && popIndex == pop.length) {
                isPopOrder = true;
            }
        }

        return isPopOrder;
    }

}
