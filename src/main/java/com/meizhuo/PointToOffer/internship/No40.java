package com.meizhuo.PointToOffer.internship;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Classname No40
 * @Description 用一个栈实现另一个栈的排序
 * @Date 2019/9/15 14:30
 * @Created by Gangan
 */
public class No40 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> help = new Stack<>();
        for (int i = 0; i < count; i++) {
            stack.push(scanner.nextInt());
        }

        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

}
