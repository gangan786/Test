package com.meizhuo.temp;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname No42
 * @Description 随手笔试
 * @Date 2019/9/16 10:51
 * @Created by Gangan
 */
public class No42 {

    public static void main(String[] args) {
        /**
         *运行结果：
         * 替换前：<xml><if test="flag>=1" abc="flag<2">aaa&gt;&lt;bbb</if><if test="flag<=1">aaa&gt;&lt;bbb</if><if test="flag>=1">aaa&gt;&lt;bbb</if><if abc="flag>=1">aaa&gt;&lt;bbb</if></xml>
         * 替换后的结果为：<xml><if test="flag&lt;=1" abc="flag<2">aaa&gt;&lt;bbb</if><if test="flag&gt;=1">aaa&gt;&lt;bbb</if><if test="flag&lt;=1">aaa&gt;&lt;bbb</if><if abc="flag>=1">aaa&gt;&lt;bbb</if></xml>
         */

        String res = "<xml><if test=\"flag>=1\" abc=\"flag<2\">aaa&gt;&lt;bbb</if><if test=\"flag<=1\">aaa&gt;&lt;bbb</if>" +
                "<if test=\"flag>=1\">aaa&gt;&lt;bbb</if>" +
                "<if abc=\"flag>=1\">aaa&gt;&lt;bbb</if></xml>";
        System.out.println("替换前：" + res);
        String element = "if";
        String attribute = "test";
        //用于匹配包含test属性的if标签
        String firstRegex = "<" + element + ".*?" + attribute + ".*?\">";
        //用于匹配test属性
        String secondRegex = attribute + "=\".*?\"";
        Pattern p1 = Pattern.compile(firstRegex);
        Matcher m1 = p1.matcher(res);
        while (m1.find()) {
            //获取到了匹配的字符串
            Pattern p2 = Pattern.compile(secondRegex);
            Matcher m2 = p2.matcher(m1.group());
            if (m2.find()) {
                String a = m2.group();
                //对单独的test="flag>=1"里面的><进行匹配替代
                String b = a.replaceAll(">", "&lt;");
                String c = b.replaceAll("<", "&gt;");
                //a是最原始的test="flag>=1"，c是替换后的结果：test="flag&lt;=1"，并将a c进行替换
                res = res.replaceAll(a, c);
            }
        }
        System.out.println("替换后的结果为："+res);
    }

}
