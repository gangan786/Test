package com.meizhuo.CrazyJava.Exception;

public class FinallyFlowTest {
    public static void main(String[] args) {
        int a = test();
        System.out.println(a);
    }

    private static int test() {
        int count = 5;
        try {
            ;
            throw new RuntimeException();
        } finally {
            System.out.println("finally块被执行");
            return ++count;
        }
    }
}
