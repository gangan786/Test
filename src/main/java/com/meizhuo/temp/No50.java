package com.meizhuo.temp;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Classname No50
 * @Description 找出重复的数
 * @Date 2019/9/21 15:26
 * @Created by Gangan
 */
public class No50 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] target = scanner.next().split(",");
            HashSet<String> strings = new HashSet<>();
            boolean flag=true;
            for (int i = 0; i < target.length; i++) {
                if (!strings.add(target[i])) {
                    System.out.println("True");
                    flag=false;
                    break;
                }
            }
            if (flag) {
                System.out.println("False");
            }
        }
    }

}
