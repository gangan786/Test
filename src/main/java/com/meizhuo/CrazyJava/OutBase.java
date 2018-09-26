package com.meizhuo.CrazyJava;

import java.io.Serializable;

public class OutBase  {
    class InnerBase extends OutBase{

    }
    class Inner extends InnerBase{

    }

    class In extends Inner{

    }

    public static void main(String[] args) {
        System.out.println("测试");
        Inner inner=new OutBase().new Inner();
    }
}
