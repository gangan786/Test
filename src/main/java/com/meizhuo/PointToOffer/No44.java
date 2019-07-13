package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No44
 * @Description 数字序列中某一位的数字
 * @Date 2019/7/13 21:20
 * @Created by Gangan
 */
public class No44 {

    @Test
    public void test() {
        System.out.println(digitAtIndex(1001));
    }

    public int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        int digit = 1;
        while (true) {
            int numbers = countOfInteger(digit);
            if (index < digit * numbers) {
                return digitAtIndex(index, digit);
            }
            index -= digit * numbers;
            digit++;
        }

    }

    private int digitAtIndex(int index, int digit) {
        int number = beginNumber(digit) + index / digit;
        int indexFromRight = digit - index % digit;
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    private int beginNumber(int digit) {
        if (digit == 1) {
            return 0;
        }
        return (int) Math.pow(10, digit - 1);
    }

    private int countOfInteger(int digit) {
        if (digit == 1) {
            return 10;
        }
        return (int) (9 * Math.pow(10, digit - 1));
    }

}
