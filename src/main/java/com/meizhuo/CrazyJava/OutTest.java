package com.meizhuo.CrazyJava;

class Out {
    class In {
        public void test() {
            System.out.println("In的test方法");
        }
    }

    class A extends In {

    }
}

public class OutTest extends Out.In {
    public OutTest() {
        new Out().super();
    }

    public static void main(String[] args) {
        Out.A a=new Out().new A();
        a.test();
    }
}
