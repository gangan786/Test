package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No21
 * @Description 对数组中的数字进行分类
 * @Date 2019/7/1 10:16
 * @Created by Gangan
 */
public abstract class No21 {

    /**
     * 由子类实现具体的分类策略
     *
     * @param target
     * @return
     */
    public abstract boolean selectStrategy(int target);

    public void recoderOddEvent(int[] numbers) {
        int startIndex = 0;
        int endIndex = numbers.length - 1;
        while (startIndex < endIndex) {
            while (startIndex < endIndex && selectStrategy(numbers[startIndex])) {
                startIndex++;
            }
            while (startIndex < endIndex && !selectStrategy(numbers[endIndex])) {
                endIndex--;
            }

            if (startIndex < endIndex) {
                int temp = numbers[startIndex];
                numbers[startIndex] = numbers[endIndex];
                numbers[endIndex] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        No21 no21 = new No21() {
            @Override
            public boolean selectStrategy(int target) {
                if ((target & 0x1) == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        no21.recoderOddEvent(numbers);
    }

}
