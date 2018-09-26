package com.meizhuo.DesignPatterns.DesignPatterns_9.费用处理;

public abstract class Leader {
    protected Leader nextLeader;//更高一级的处理者

    public final void handleRequest(int money) {
        if (money <= limit()) {
            handle(money);
        } else {
            if (nextLeader != null) {
                nextLeader.handleRequest(money);
            } else {
                System.out.println("你居然用了"+money+"元这么多钱"+"你被开除了！！");
            }
        }
    }

    protected abstract void handle(int money);

    protected abstract int limit();
}
