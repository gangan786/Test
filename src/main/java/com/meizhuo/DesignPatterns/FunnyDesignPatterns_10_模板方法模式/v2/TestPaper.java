package com.meizhuo.DesignPatterns.FunnyDesignPatterns_10_模板方法模式.v2;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns.v1
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/13 11:25
 * @UpdateUser:
 * @UpdateDate: 2019/1/13 11:25
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */

public abstract class TestPaper {

    /**
     * answer for question1
     *
     * @return answer
     */
    public abstract String answer1();

    /**
     * answer for question2
     *
     * @return answer
     */
    public abstract String answer2();

    /**
     * answer for question3
     *
     * @return answer
     */
    public abstract String answer3();

    public void testQuestion1() {
        System.out.println("如何增强党的执政本领？\n a 增强学习本领 b 增强依法执政本领 c 增强改革创新本领 d 增强群众工作本领");
        System.out.println("答案：" + answer1());
    }

    public void testQuestion2() {
        System.out.println("毛泽东思想的灵魂？\n a 实事求是 b 群众路线 c 独立自主 d 氪金至上");
        System.out.println("答案：" + answer2());
    }

    public void testQuestion3() {
        System.out.println("三大改造中三个行业是那指？\n a 农业 b 手工业 c 资本主义工商业 d 餐饮业");
        System.out.println("答案：" + answer3());
    }

}
