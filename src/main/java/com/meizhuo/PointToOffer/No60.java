package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No60
 * @Description n个骰子的点数
 * @Date 2019/7/26 15:33
 * @Created by Gangan
 */
public class No60 {

    private static final int MAX_VALUE_DICE = 6;
    private static final int MIN_VALUE_DICE = 1;

    @Test
    public void test() {
        printProbability(1);
        System.out.println("---------------------------------------------");
        printProbability2(1);
    }

    public void printProbability(int countOfDice) {
        if (countOfDice < 0) {
            throw new IllegalArgumentException("参数非法");
        }
        int maxSum = MAX_VALUE_DICE * countOfDice;
        int minSum = MIN_VALUE_DICE * countOfDice;
        int[] results = new int[maxSum - minSum + 1];

        probability(countOfDice, results);

        double total = Math.pow(MAX_VALUE_DICE, countOfDice);
        for (int i = 0; i < results.length; i++) {
            System.out.println("和为：" + (i + minSum) + " 出现的概率为：" + (results[i] / total));
        }

    }

    private void probability(int countOfDice, int[] results) {
        for (int i = MIN_VALUE_DICE; i <= MAX_VALUE_DICE; i++) {
            probability(countOfDice, countOfDice, i, results);
        }
    }

    private void probability(int original, int diceIndex, int sum, int[] results) {

        if (diceIndex == 1) {
            results[sum - original]++;
        } else {
            for (int i = MIN_VALUE_DICE; i <= MAX_VALUE_DICE; i++) {
                probability(original, diceIndex - 1, sum + i, results);
            }
        }

    }

    public void printProbability2(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("参数非法");
        }
        int[][] result = new int[2][MAX_VALUE_DICE * number + 1];
        int flag = 0;

        for (int i = 1; i < MAX_VALUE_DICE; i++) {
            result[flag][i] = 1;
        }


        for (int k = 2; k <= number; k++) {

            for (int i = 0; i < k; i++) {
                result[1 - flag][i] = 0;
            }

            for (int i = k; i <= MAX_VALUE_DICE * k; i++) {
                result[1 - flag][i] = 0;

                for (int j = 1; j <= i && j <= MAX_VALUE_DICE; ++j) {
                    result[1 - flag][i] += result[flag][i - j];
                }

            }

            flag = 1 - flag;
        }

        double total = Math.pow(MAX_VALUE_DICE, number);
        for (int i = number; i < MAX_VALUE_DICE * number; i++) {
            double ratio = result[flag][i] / total;
            System.out.println("和为：" + i + " 出现的概率为：" + ratio);
        }

    }


}
