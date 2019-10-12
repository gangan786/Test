package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No56
 * @Description 判断是否为回文数
 * @Date 2019/10/12 21:04
 * @Created by Gangan
 */
public class No56 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] target = scanner.next().toCharArray();
        int leftIndex = 0;
        int rightIndex = target.length - 1;
        boolean isTrue = false;
        while (true) {
            if (leftIndex == rightIndex || rightIndex < leftIndex) {
                isTrue = true;
                break;
            } else {
                if (target[leftIndex] == target[rightIndex]) {
                    leftIndex++;
                    rightIndex--;
                } else {
                    break;
                }
            }
        }
        if (isTrue) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }

}
