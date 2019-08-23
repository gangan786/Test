package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No16
 * @Description 依图笔试_1
 * @Date 2019/8/23 19:06
 * @Created by Gangan
 */
public class No16 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine();
        String ge = "I,II,III,IV,V,VI,VII,VIII,IX";
        String minGe = "I,II,III,IV,V,IV,VII,VIII,IX";
        String shi = "X,XX,XXX,XL,L,LX,LXX,LXXX,XC";
        String minShi = "X,XX,XXX,XL,L,XL,LXX,LXXX,XC";
        String[] minGeList = minGe.split(",");
        String[] minShiList = minShi.split(",");

        String[] geList = ge.split(",");
        String[] shiList = shi.split(",");

        char[] chars = target.toCharArray();
        int spiltIndex=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'I' || chars[i] == 'V') {
                spiltIndex=i;
                break;
            }
            spiltIndex++;
        }

        StringBuilder leftString = new StringBuilder();
        StringBuilder rightString = new StringBuilder();
        for (int i = 0; i < spiltIndex; i++) {
            leftString.append(chars[i]);
        }
        for (int i = spiltIndex; i < chars.length; i++) {
            rightString.append(chars[i]);
        }

        int shiIndex = findIndex(leftString, shiList);
        int geIndex = findIndex(rightString, geList);

        String result="";

        if (shiIndex != -1) {
            result=minShiList[shiIndex];
        }
        if (geIndex != -1) {
            result=result+minGeList[geIndex];
        }

        System.out.println(result);

    }

    private static int findIndex(StringBuilder leftString, String[] shiList) {
        for (int i = 0; i < shiList.length; i++) {
            if (shiList[i].equals(leftString.toString())) {
                return i;
            }
        }
        return -1;
    }

}
