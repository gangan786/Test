package com.meizhuo.PointToOffer.internship;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname No1
 * @Description 排列组合
 * @Date 2019/8/5 14:37
 * @Created by Gangan
 */
public class No1 {

    @Test
    public void test() {
        Set<String> word = getWord("ABC");
        System.out.println(word);
    }

    public  Set<String> getWord(String str) {
        Set<String> perm = new HashSet<String>();

        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0);
        String rem = str.substring(1);
        Set<String> words = getWord(rem);
        for (String strNew : words) {
            for (int i = 0; i <= strNew.length(); i++) {
                perm.add(insertChar(strNew, initial, i));
            }
        }
        return perm;
    }

    private String insertChar(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }


}
