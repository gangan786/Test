package com.meizhuo.PointToOffer.internship;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @Classname No33
 * @Description 两个栈组成的队列
 * @Date 2019/9/14 12:51
 * @Created by Gangan
 */
public class No33 {

    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(scanner.readLine());
        Stack<Integer> headStack = new Stack<>();
        Stack<Integer> tailStack = new Stack<>();
        for (int i = 0; i < count; i++) {
            String[] order = scanner.readLine().split(" ");
            if ("add".equals(order[0])) {
                tailStack.push(Integer.valueOf(order[1]));
            }
            if ("peek".equals(order[0])) {
                if (!headStack.isEmpty()) {
                    System.out.println(headStack.peek());
                } else {
                    while (!tailStack.isEmpty()) {
                        headStack.push(tailStack.pop());
                    }
                    System.out.println(headStack.peek());
                }
            }
            if ("poll".equals(order[0])) {
                if (!headStack.isEmpty()) {
                    headStack.pop();
                } else {
                    while (!tailStack.isEmpty()) {
                        headStack.push(tailStack.pop());
                    }
                    headStack.pop();
                }
            }
        }
    }

}
