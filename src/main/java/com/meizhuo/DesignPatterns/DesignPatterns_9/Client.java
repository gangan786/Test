package com.meizhuo.DesignPatterns.DesignPatterns_9;

import com.meizhuo.DesignPatterns.DesignPatterns_9.Handle.AbstractHandle;
import com.meizhuo.DesignPatterns.DesignPatterns_9.Handle.Handle1;
import com.meizhuo.DesignPatterns.DesignPatterns_9.Handle.Handle2;
import com.meizhuo.DesignPatterns.DesignPatterns_9.Handle.Handle3;
import com.meizhuo.DesignPatterns.DesignPatterns_9.Require.AbstractRequest;
import com.meizhuo.DesignPatterns.DesignPatterns_9.Require.Request1;
import com.meizhuo.DesignPatterns.DesignPatterns_9.Require.Request2;
import com.meizhuo.DesignPatterns.DesignPatterns_9.Require.Request3;

public class Client {
    public static void main(String[] args) {
//构造三个处理对象
        AbstractHandle handle1 = new Handle1();
        AbstractHandle handle2 = new Handle2();
        AbstractHandle handle3 = new Handle3();

        //设置当前处理者下一个节点的处理对象
        handle1.nextHandle = handle2;
        handle2.nextHandle = handle3;

        //构建三个请求者对象
        AbstractRequest request1 = new Request1("Request1");
        AbstractRequest request2 = new Request2("Request2");
        AbstractRequest request3 = new Request3("Request3");

        //总是从链式的顶端发起请求
        handle1.handleRequest(request1);
        handle1.handleRequest(request2);
        handle1.handleRequest(request3);

    }
}
