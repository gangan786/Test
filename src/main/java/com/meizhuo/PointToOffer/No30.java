package com.meizhuo.PointToOffer;

import java.util.Stack;

/**
 * @Classname No30
 * @Description 包含min函数的栈
 * @Date 2019/7/3 15:02
 * @Created by Gangan
 */
public class No30 {

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(Integer element) {
        Integer currentMin = minStack.peek();
        if (minStack.isEmpty() || currentMin > element) {
            minStack.push(currentMin);
        } else {
            minStack.push(minStack.peek());
        }
        dataStack.push(element);
    }

    public Integer pop() {
        if (!dataStack.isEmpty() && !minStack.isEmpty()) {
            minStack.pop();
            return dataStack.pop();
        }
        throw new RuntimeException("空栈");
    }

    public Integer min() {
        if (!dataStack.isEmpty() && !minStack.isEmpty()) {
            return minStack.peek();
        }
        throw new RuntimeException("空栈");
    }

}
