package com.meizhuo.DesignPatterns.DesignPatterns_9.费用处理;

public class GroupLeader extends Leader {
    @Override
    protected void handle(int money) {
        System.out.println("组长处理了"+money+"元请求");
    }

    @Override
    protected int limit() {
        return 1000;//表明组长只有处理1000块请求的能力
    }
}
