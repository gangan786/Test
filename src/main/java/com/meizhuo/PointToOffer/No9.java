package com.meizhuo.PointToOffer;

import org.junit.Test;

import java.util.Stack;

/**
 * @Classname No9
 * @Description 使用两个栈实现队列功能
 * @Date 2019/6/24 16:46
 * @Created by Gangan
 */
public class No9 {

    class Queue<T>{
        private final Stack<T> stackAdd;
        private final Stack<T> stackDel;

        public Queue() {
            stackAdd=new Stack<>();
            stackDel=new Stack<>();
        }

        public void add(T element) {
            stackAdd.add(element);
        }

        public T remove() {
            if (stackDel.isEmpty()) {
                while (!stackAdd.isEmpty()) {
                    stackDel.push(stackAdd.pop());
                }
            }

            if (stackDel.isEmpty()) {
                throw new RuntimeException("队列为空，非法操作");
            }

            return stackDel.pop();
        }


    }

    @Test
    public void test() {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 9; i++) {
            queue.add(i);
        }

        queue.remove();
        queue.remove();
    }

}
