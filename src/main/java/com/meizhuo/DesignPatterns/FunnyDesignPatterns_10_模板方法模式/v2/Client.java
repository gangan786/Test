package com.meizhuo.DesignPatterns.FunnyDesignPatterns_10_模板方法模式.v2;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_10_模板方法模式.v2
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/13 12:03
 * @UpdateUser:
 * @UpdateDate: 2019/1/13 12:03
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {
    public static void main(String[] args) {
        TestPaper paperA = new TestPaperA();
        paperA.testQuestion1();
        paperA.testQuestion2();
        paperA.testQuestion3();
        System.out.println("--------------------------");
        TestPaper paperB = new TestPaperB();
        paperB.testQuestion1();
        paperB.testQuestion2();
        paperB.testQuestion3();
    }
}
