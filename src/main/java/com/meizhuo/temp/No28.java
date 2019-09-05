package com.meizhuo.temp;


import java.util.Scanner;
import java.util.Stack;

public class No28 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {

        StringBuilder result = new StringBuilder();

        char[] charArray = expr.toCharArray();
        int left=0;
        int right=0;
        for (int i = charArray.length-1; i>=0; i++) {
            if (charArray[i] != '(' || charArray[i] != ')') {
                result.append(charArray[i]);
                if (charArray[i] == '(') {
                    left++;
                } else {
                    right++;
                }
            }
        }

        return left==right?result.toString():"";

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
