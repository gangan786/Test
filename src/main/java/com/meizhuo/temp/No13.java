package com.meizhuo.temp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Classname No13
 * @Description TODO
 * @Date 2019/8/20 19:29
 * @Created by Gangan
 */
public class No13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] target = s.split(",");
        int[] ints = new int[target.length];
        for (int i = 0; i < target.length; i++) {
            ints[i]=Integer.valueOf(target[i]);
        }
        int[] minNumber = getMinNumber(ints);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < minNumber.length; i++) {
            builder.append(minNumber[i]);
        }
        System.out.println(builder);
    }


    public static int[] getMinNumber(int[] target) {


        String[] str = new String[target.length];

        for (int i = 0; i < target.length; i++) {
            str[i] = target[i] + "";
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String first = o1 + o2;
                String second = o2 + o1;
                return first.compareTo(second);
            }
        });

        int[] result = new int[target.length];
        for (int i = 0; i < target.length; i++) {
            result[i] = Integer.valueOf(str[i]);
        }

        return result;
    }

}
