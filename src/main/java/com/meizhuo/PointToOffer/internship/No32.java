package com.meizhuo.PointToOffer.internship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Classname No32
 * @Description 设计getMin功能的栈
 * @Date 2019/9/14 12:05
 * @Created by Gangan
 */
public class No32 {

    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(scanner.readLine());
        Stack<Integer> dataStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        for (int i = 0; i < count; i++) {
            String orders = scanner.readLine();
            String[] order = orders.split(" ");
            if ("push".equals(order[0])) {
                dataStack.push(Integer.valueOf(order[1]));
                if (minStack.isEmpty() || minStack.peek() >= Integer.valueOf(order[1])) {
                    //注意这里的判断条件是大于等于
                    minStack.push(Integer.valueOf(order[1]));
                }
            }
            if ("pop".equals(order[0])) {
                Integer pop = dataStack.pop();
                if (pop.equals(minStack.peek())) {
                    minStack.pop();
                }
            }
            if ("getMin".equals(order[0])) {
                System.out.println(minStack.peek());
            }
        }
    }

}
