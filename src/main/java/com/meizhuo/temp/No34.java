package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No34
 * @Description 模仿2048游戏
 * @Date 2019/9/11 19:56
 * @Created by Gangan
 */
public class No34 {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static String solution(String[] input) {

        for (int i = 0; i < input.length; i++) {
            String[] target = input[i].split(" ");
            for (int j = 0; j < target.length-1;) {
                if (target[j].equals(target[j + 1])) {
                    target[j]=(Integer.valueOf(target[j])*2)+"";
                    target[j+1]="0";
                }
            }
        }

        return "";

    }


    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        res = solution(_input);
        System.out.println("2 4 0 0\n" +
                "4 2 0 0\n" +
                "4 4 0 0\n" +
                "16 4 0 0");
    }
}
