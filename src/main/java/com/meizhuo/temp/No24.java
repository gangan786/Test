package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No24
 * @Description 排队
 * @Date 2019/9/1 20:29
 * @Created by Gangan
 */
public class No24 {

    static class Customer {

        public int a;
        public int b;

        public Customer(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private static long minResult = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        if (count == 0) {
            System.out.println("0");
            return;
        }
        Customer[] queue = new Customer[count];
        for (int i = 0; i < queue.length; i++) {
            queue[i] = new Customer(scanner.nextInt(), scanner.nextInt());
        }

        per(queue, 0);
        System.out.println(minResult);

    }

    private static void per(Customer[] target, int beginIndex) {
        if (beginIndex == target.length) {
            //计算不满意度的总和
            long result = 0;
            for (int i = 0; i < target.length; i++) {
                Customer customer = target[i];
                long price = i * customer.a + (target.length - i - 1) * customer.b;
                result += price;
            }

            minResult = Math.min(result, minResult);

        } else {
            for (int curIndex = beginIndex; curIndex < target.length; curIndex++) {
                Customer temp = target[curIndex];
                target[curIndex] = target[beginIndex];
                target[beginIndex] = temp;

                per(target, beginIndex + 1);

                temp = target[curIndex];
                target[curIndex] = target[beginIndex];
                target[beginIndex] = temp;
            }
        }
    }

}
