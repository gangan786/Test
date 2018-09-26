package com.meizhuo.DesignPatterns.DesignPatterns_9.Require;

public abstract class AbstractRequest {
    private Object object;//处理对象

    public AbstractRequest(Object object) {
        this.object = object;
    }

    //获取处理的对象
    public Object getContent() {
        return object;
    }

    //获取请求级别
    public abstract int getRequestLevel();

}
