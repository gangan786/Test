package com.meizhuo.DesignPatterns.FunnyDesignPatterns_10_模板方法模式.v1;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_10_模板方法模式.v1
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/13 11:46
 * @UpdateUser:
 * @UpdateDate: 2019/1/13 11:46
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class TestPaperB extends TestPaper {
    @Override
    public void testQuestion1() {
        super.testQuestion1();
        System.out.println("答案：abc");
    }

    @Override
    public void testQuestion2() {
        super.testQuestion2();
        System.out.println("答案：abcd");
    }

    @Override
    public void testQuestion3() {
        super.testQuestion3();
        System.out.println("答案：cd");
    }
}
