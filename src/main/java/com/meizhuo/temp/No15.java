package com.meizhuo.temp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Classname No15
 * @Description 火星文
 * @Date 2019/8/22 16:25
 * @Created by Gangan
 */
public class No15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] list = s.split(" ");
        int[] time = new int[26];

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < list.length; i++) {
            String a = list[i];
            for (int j = 0; j < a.length(); j++) {
                char c = a.charAt(j);
                if (c >= 'A' && c <= 'Z') {
                    time[c - 'A']++;
                } else {
                    time[c - 'a']++;
                }
            }
        }

        for (int i = 0; i < time.length; i++) {
            if (time[i] != 0) {
                char t = (char) ('a'+i);
                builder.append(t);
            }
        }

        for (int i = 0; i < list.length; i++) {
            String squ = list[i];
            change(squ,builder);
        }

        System.out.println(builder);

    }

    private static void change(String squ, StringBuilder builder) {
        for (int i = 0; i < squ.length(); i++) {
            for (int j = i + 1; j < squ.length(); j++) {
                //根据索引获得字符
                char first = squ.charAt(i);
                char second = squ.charAt(j);
                int firstIndex = builder.indexOf(first + "");
                int secondIndex = builder.indexOf(second + "");
                if (firstIndex > secondIndex) {
                    //将secondIndex所指向的插到firstIndex的后面 同时将secondIndex所指向的删除

                    builder.insert(firstIndex+1,second);
                    builder.replace(secondIndex,secondIndex+1,"");
                }
            }
        }
    }

}
