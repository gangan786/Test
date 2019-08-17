package com.meizhuo.PointToOffer.internship;

/**
 * @Classname No12
 * @Description 丰收
 * @Date 2019/8/17 17:22
 * @Created by Gangan
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 又到了丰收的季节，恰逢小易去牛牛的果园里游玩。
 * 牛牛常说他对整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。
 * 在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往右数第x个苹果是属于哪一堆的。
 * 牛牛觉得这个问题太简单，所以希望你来替他回答。
 * 输入描述:
 * 第一行一个数n(1 <= n <= 105)。
 * 第二行n个数ai(1 <= ai <= 1000)，表示从左往右数第i堆有多少苹果
 * 第三行一个数m(1 <= m <= 105)，表示有m次询问。
 * 第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆。
 * 输出描述:
 * m行，第i行输出第qi个苹果属于哪一堆。
 * 示例1
 * 输入
 * <p>
 * 5
 * 2 7 3 4 9
 * 3
 * 1 25 11
 * 输出
 * <p>
 * 1
 * 5
 * 3
 */
public class No12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfGroup = scanner.nextInt();
        int[] groups = new int[countOfGroup];
        for (int i = 0; i < groups.length; i++) {
            int preIndex = i == 0 ? 0 : i - 1;
            groups[i] = groups[preIndex] + scanner.nextInt();
        }
        int countOfQuestion = scanner.nextInt();
        int[] questions = new int[countOfQuestion];
        for (int i = 0; i < questions.length; i++) {
            questions[i] = scanner.nextInt();
        }

        for (int i = 0; i < questions.length; i++) {
            int ans = Arrays.binarySearch(groups, questions[i]);
            if (ans >= 0) {
                System.out.println(ans + 1);
            } else {
                System.out.println(-ans);
            }
        }

    }

}
