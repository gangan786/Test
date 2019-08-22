package com.meizhuo.PointToOffer.internship;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Classname No17
 * @Description 小易的字典
 * @Date 2019/8/22 10:09
 * @Created by Gangan
 */
public class No17 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfA = scanner.nextInt();
        int countOfZ = scanner.nextInt();
        int index = scanner.nextInt();

        //构建
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < countOfA; i++) {
            string.append("a");
        }
        for (int i = 0; i < countOfZ; i++) {
            string.append("z");
        }

        HashSet<String> result = new HashSet<>();

        per(string.toString().toCharArray(),0,result);

        Object[] array = result.toArray();

        Arrays.sort(array, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                String a = (String) o1;
                String b = (String) o2;
                return a.compareTo(b);
            }
        });

        if (index > array.length + 1) {
            System.out.println(-1);
        } else {
            System.out.println((String) array[index - 1]);
        }

    }

    public static void per(char[] target, int beginIndex, HashSet<String> result) {
        if (beginIndex == target.length) {
            result.add(new String(target));
        } else {
            for (int i = beginIndex; i < target.length; i++) {
                char temp=target[i];
                target[i]=target[beginIndex];
                target[beginIndex]=temp;

                per(target,beginIndex+1,result);

                 temp=target[i];
                target[i]=target[beginIndex];
                target[beginIndex]=temp;
            }
        }
    }

}
