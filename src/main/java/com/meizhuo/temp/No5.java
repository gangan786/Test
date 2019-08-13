package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No5
 * @Description 起床上课
 * @Date 2019/8/11 19:03
 * @Created by Gangan
 */
public class No5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfClock = scanner.nextInt();
        int[] Hi = new int[countOfClock];
        int[] Mi = new int[countOfClock];

        for (int i = 0; i < countOfClock; i++) {
            int hour = scanner.nextInt();
            int minu = scanner.nextInt();
            Hi[i] = hour;
            Mi[i] = minu;
        }

        int sumMin = scanner.nextInt();
        int timeToClassHour = scanner.nextInt();
        int timeToClassMinu = scanner.nextInt();

        int minH = timeToClassHour;
        int minM = timeToClassMinu;

        if (timeToClassMinu - sumMin < 0) {
            minM = sumMin - timeToClassMinu;
            minH -= 1;
            if (minH < 0) {
                minH = 12;
            }
        } else {
            minM = timeToClassMinu - sumMin;
        }

        int result = 0;

        for (int i = 0; i < countOfClock; i++) {
            if (Hi[i] <= minH && Mi[i] <= minM) {
                if (Hi[result] <= Hi[i] && Mi[result] <= Mi[i]) {
                    result = i;
                }
            }
        }

        System.out.println(Hi[result] + " " + Mi[result]);

    }

}
