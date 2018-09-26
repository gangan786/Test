package com.meizhuo.DesignPatterns.DesignPatterns_9.Handle;

import com.meizhuo.DesignPatterns.DesignPatterns_9.Require.AbstractRequest;

public abstract class AbstractHandle {
    public AbstractHandle nextHandle;//下一节点上的处理者对象

    public final void handleRequest(AbstractRequest request) {
        //判断当前处理对象的处理级别是否与请求者的处理级别一致
        if (getHandleLevel() == request.getRequestLevel()) {
            //一致则由该对象处理
            handle(request);
        } else {
            //否则该请求转发给下一个节点
            if (nextHandle != null) {
                nextHandle.handleRequest(request);
            } else {
                System.out.println("All of Handle can not handle this request");
            }
        }
    }

    //处理请求
    protected abstract void handle(AbstractRequest request);

    //获取处理对象的级别
    protected abstract int getHandleLevel();
}
