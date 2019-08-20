package com.meizhuo.temp;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Classname No12
 * @Description TODO
 * @Date 2019/8/20 19:22
 * @Created by Gangan
 */
public class No12 {

    @Test
    public void test() {
        System.out.println(reverseSentence("Tim is a student."));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine();
        System.out.println(reverseSentence(target));
    }

    public static String reverseSentence(String target) {
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

    private static void reverse(char[] targetArray, int beginIndex, int endIndex) {
        while (beginIndex < endIndex) {
            char temp = targetArray[beginIndex];
            targetArray[beginIndex] = targetArray[endIndex];
            targetArray[endIndex] = temp;
            beginIndex++;
            endIndex--;
        }
    }

}
