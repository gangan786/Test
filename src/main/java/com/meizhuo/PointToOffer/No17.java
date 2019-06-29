package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No17
 * @Description 打印从1到最大的n位数
 * @Date 2019/6/29 15:53
 * @Created by Gangan
 */
public class No17 {

    public void printToMaxOfDigits(int target) {
        if (target < 0) {
            return;
        }
        char[] numbers = new char[target];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = '0';
        }
        while (!increment(numbers)) {
            System.out.println(printNum(numbers));
        }
    }

    public void printToMaxOfDigitsByRecursion(int target) {
        if (target < 0) {
            return;
        }
        char[] numbers = new char[target];
        for (int i = 0; i < 10; i++) {
            numbers[0] = (char) (i + '0');
            incrementByRecursion(numbers, target, 0);
        }
    }

    private void incrementByRecursion(char[] numbers, int length, int index) {
        if (index == length - 1) {
            System.out.println(printNum(numbers));
            return;
        }
        for (int i = 0; i < 10; i++) {
            numbers[index + 1] = (char) (i + '0');
            incrementByRecursion(numbers, length, index + 1);
        }
    }

    private String printNum(char[] numbers) {
        StringBuilder num = new StringBuilder();
        int start = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != '0') {
                start = i;
                break;
            }
        }
        num.append(numbers, start, numbers.length - start);
        return num.toString();
    }


    private boolean increment(char[] numbers) {
        boolean isOver = false;
        int length = numbers.length;
        int flow = 0;
        for (int i = length - 1; i >= 0; i--) {
            int num = numbers[i] - '0' + flow;
            if (i == length - 1) {
                num++;
            }
            if (num >= 10) {
                if (i == 0) {
                    isOver = true;
                } else {
                    num = num - 10;
                    flow = 1;
                    numbers[i] = (char) ('0' + num);
                }
            } else {
                numbers[i] = (char) ('0' + num);
                break;
            }
        }
        return isOver;
    }

    @Test
    public void test() {
        //printToMaxOfDigits(8);
        printToMaxOfDigitsByRecursion(2);
    }

}
