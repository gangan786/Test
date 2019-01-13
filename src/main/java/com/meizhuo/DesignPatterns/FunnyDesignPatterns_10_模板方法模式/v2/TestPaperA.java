package com.meizhuo.DesignPatterns.FunnyDesignPatterns_10_模板方法模式.v2;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_10_模板方法模式.v2
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/13 12:00
 * @UpdateUser:
 * @UpdateDate: 2019/1/13 12:00
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class TestPaperA extends TestPaper {
    @Override
    public String answer1() {
        return "abcd";
    }

    @Override
    public String answer2() {
        return "abc";
    }

    @Override
    public String answer3() {
        return "abc";
    }
}
