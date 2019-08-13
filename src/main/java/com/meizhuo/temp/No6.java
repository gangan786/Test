package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No6
 * @Description 发工资
 * @Date 2019/8/11 20:02
 * @Created by Gangan
 */
public class No6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] years = new int[count];
        for (int i = 0; i < years.length; i++) {
            years[i]=scanner.nextInt();
        }

        int sum=0;
        int per=0;
        if (years.length >= 2 && years[0] > years[1]) {
            per = 200;
            sum = 200;
        } else {
            per=100;
            sum=100;
        }

        for (int i = 1; i < years.length; i++) {
            if (years[i - 1] < years[i]) {
                sum=sum+per+100;
                per+=100;
            } else if (years[i - 1] == years[i]) {
                sum += per;
            } else {
                per=100;
                sum+=100;
            }
        }

        System.out.println(sum);

    }

}
