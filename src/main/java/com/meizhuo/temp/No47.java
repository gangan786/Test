package com.meizhuo.temp;

import java.util.*;

/**
 * @Classname No47
 * @Description 字符集合
 * @Date 2019/9/19 9:42
 * @Created by Gangan
 */
public class No47 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            char[] c = in.next().toCharArray();
            StringBuffer sb = new StringBuffer();
            Set<Character> set = new HashSet<Character>();
            for(int i = 0;i<c.length;i++){
                if(set.add(c[i])) {
                    sb.append(c[i]);
                }
            }
            System.out.println(sb.toString());
        }
    }

}
