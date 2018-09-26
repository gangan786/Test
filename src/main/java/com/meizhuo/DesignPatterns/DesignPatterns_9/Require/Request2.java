package com.meizhuo.DesignPatterns.DesignPatterns_9.Require;

public class Request2 extends AbstractRequest {
    public Request2(Object object) {
        super(object);
    }

    @Override
    public int getRequestLevel() {
        return 2;
    }
}
