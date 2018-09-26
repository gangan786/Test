package com.meizhuo.DesignPatterns.DesignPatterns_9.Handle;

import com.meizhuo.DesignPatterns.DesignPatterns_9.Require.AbstractRequest;

public class Handle1 extends AbstractHandle {
    @Override//在这个实现方法里面请求进行具体的处理，这里处理的请求是这个Handle能够处理的，即满足getHandleLevel() == request.getRequestLevel()
    protected void handle(AbstractRequest request) {
        System.out.println("Handle1 handle request:"+request.getRequestLevel()+"  Request Content is "+request.getContent());
    }

    @Override
    protected int getHandleLevel() {
        return 1;
    }
}
