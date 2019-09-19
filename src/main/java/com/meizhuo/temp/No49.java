package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No49
 * @Description 求询问次数
 * 题目描述：
 * Alice现在有一个数x，在范围[0,2的n次方)内。你需要询问Alice一些问题。
 * 每次询问有一个数t，Alice会回答你 t&x 是否等于t。
 * 你不能根据已有的回答改变接下来的询问（即询问需要提前想好）。
 * 你需要最少询问多少次来保证你能确定x的值。输出答案mod106+3
 *
 * &的意思是位与运算
 *
 * 当且仅当两种方案中有一个询问不同，我们就认为两种方法是不同的。
 * 例如询问[1,2]和[1,3]是不同的，[1,2][2,1]也是不同的（尽管他们得到了相同的结果）
 * @Date 2019/9/19 16:41
 * @Created by Gangan
 */
public class No49 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
            result = result % (1000003);
        }

        System.out.print(result);
    }

}
