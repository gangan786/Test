package com.meizhuo.PointToOffer.internship;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Classname No34
 * @Description 利用递归函数和栈逆序一个栈
 * @Date 2019/9/14 13:17
 * @Created by Gangan
 */
public class No34 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < count; i++) {
            stack.push(scanner.nextInt());
        }

        reverse(stack);
    }

    private static void printStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        } else {
            Integer pop = stack.pop();
            printStack(stack);
            System.out.print(pop);
        }
    }

    private static int removeLast(Stack<Integer> stack) {
        Integer result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = removeLast(stack);
            stack.push(result);
            return last;
        }
    }

    private static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        } else {
            int last = removeLast(stack);
            reverse(stack);
            stack.push(last);
            System.out.print(last+" ");
        }
    }

}
