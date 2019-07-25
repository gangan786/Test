package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No58
 * @Description 反转字符串
 * @Date 2019/7/25 10:09
 * @Created by Gangan
 */
public class No58 {

    @Test
    public void test() {
        System.out.println(reverseSentence("Tim is a student."));
    }

    public String reverseSentence(String target) {
        char[] targetArray = target.toCharArray();
        int beginIndex = 0;
        int endIndex = targetArray.length - 1;

        reverse(targetArray, beginIndex, endIndex);
        beginIndex = endIndex = 0;
        while (beginIndex < targetArray.length) {
            if (targetArray[beginIndex] == ' ' && targetArray[endIndex] == ' ') {
                beginIndex++;
                endIndex++;
            } else if (endIndex == targetArray.length || targetArray[endIndex] == ' ') {
                reverse(targetArray, beginIndex, endIndex - 1);
                beginIndex = endIndex;
            } else {
                endIndex++;
            }
        }
        return new String(targetArray);
    }

    @Test
    public void testLeftRotateString() {
        System.out.println(leftRotateString("abcdefg", 2));
    }

    public String leftRotateString(String target, int n) {
        char[] targetArray = target.toCharArray();
        int firstStart=0;
        int firstEnd=n-1;
        int secondStart=n;
        int secondEnd=targetArray.length-1;

        reverse(targetArray,firstStart,firstEnd);
        reverse(targetArray, secondStart, secondEnd);
        reverse(targetArray,firstStart,secondEnd);
        return new String(targetArray);

    }

    private void reverse(char[] targetArray, int beginIndex, int endIndex) {
        while (beginIndex < endIndex) {
            char temp = targetArray[beginIndex];
            targetArray[beginIndex] = targetArray[endIndex];
            targetArray[endIndex] = temp;
            beginIndex++;
            endIndex--;
        }
    }

}
