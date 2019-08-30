package com.meizhuo.PointToOffer.internship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @Classname No26
 * @Description 字符串归一化
 * @Date 2019/8/30 16:32
 * @Created by Gangan
 */
public class No26 {

    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(input);
        String target = buffer.readLine().trim();

        int[] map = new int[26];
        for (int i = 0; i < target.toCharArray().length; i++) {
            map[target.charAt(i)-'a']++;
        }

        StringBuilder result = new StringBuilder(32);
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                char single= (char) ('a'+i);
                result.append(single).append(map[i]);
            }
        }

        System.out.println(result);

    }

}
