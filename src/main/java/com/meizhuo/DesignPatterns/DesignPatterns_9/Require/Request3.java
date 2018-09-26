package com.meizhuo.DesignPatterns.DesignPatterns_9.Require;

public class Request3 extends AbstractRequest {
    public Request3(Object object) {
        super(object);
    }

    @Override
    public int getRequestLevel() {
        return 3;
    }
}
