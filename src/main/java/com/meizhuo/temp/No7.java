package com.meizhuo.temp;

import java.util.Scanner;

/**
 * @Classname No7
 * @Description 解密
 * @Date 2019/8/11 20:39
 * @Created by Gangan
 */
public class No7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        String ciphertext = scanner.next();
        int[] result = new int[N];
        for (int i = 0; i < result.length; i++) {
            result[i]=-1;
        }

        result[0]=ciphertext.charAt(0);
        for (int i = 1; i <N; i++) {
            int mi = ciphertext.charAt(i)-'0';
            int a=mi;
            for (int j = 0; j < i; j++) {
                a=a^result[j];
            }
            if (mi == 0) {

            }
        }
    }

}
