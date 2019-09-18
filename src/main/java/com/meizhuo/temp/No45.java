package com.meizhuo.temp;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Classname No45
 * @Description 同构字符串
 * @Date 2019/9/18 21:28
 * @Created by Gangan
 */
public class No45 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] target = scanner.nextLine().split(";");
        HashMap<Character, Character> map = new HashMap<>(26);
        if (target[0].length() != target[1].length()) {
            System.out.println("False");
        } else {
            boolean flag=true;
            for (int i = 0; i < target[0].length(); i++) {
                char a = target[0].charAt(i);
                char b = target[1].charAt(i);
                if (map.containsKey(a)) {
                    if (!map.get(a).equals(b)) {
                        System.out.println("False");
                        flag=false;
                        break;
                    }
                } else {
                    map.put(a,b);
                }
            }
            if (flag) {
                System.out.println("True");
            }
        }


    }

}
