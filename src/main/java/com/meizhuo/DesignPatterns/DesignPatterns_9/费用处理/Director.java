package com.meizhuo.DesignPatterns.DesignPatterns_9.费用处理;

public class Director extends Leader {
    @Override
    protected void handle(int money) {
        System.out.println("主管处理了"+money+"元请求");
    }

    @Override
    protected int limit() {
        return 5000;
    }
}
