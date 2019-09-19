package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No48
 * @Description 末尾的数
 * 题目描述：
 * 小明想知道 n! ，最后一位不为 0 的数字，你能告诉他吗？ n! = n*(n-1)*(n-2)*....*3*2*1
 * @Date 2019/9/19 16:25
 * @Created by Gangan
 */
public class No48 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = 1;
        for (int i = 1; i <= n; i++) {
            sum = sum * i;
            while (sum > 0) {
                if (sum % 10 == 0) {
                    sum = sum / 10;
                } else {
                    sum = sum % 1000;
                    break;
                }
            }
        }

        while (sum > 0) {
            if (sum % 10 == 0) {
                sum = sum / 10;
            } else {
                System.out.println(sum % 10);
                break;
            }
        }

    }

}
