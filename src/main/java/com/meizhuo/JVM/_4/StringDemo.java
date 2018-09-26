package com.meizhuo.JVM._4;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.JVM._4
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/9/23 13:26
 * @UpdateUser:
 * @UpdateDate: 2018/9/23 13:26
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class StringDemo {
    private static final String MESSAGE="taobao";
    public static void main(String [] args) {
        String a ="tao"+"bao";
        String b="tao";
        String c="bao";
        System.out.println(a==MESSAGE);
        System.out.println((b+c)==MESSAGE);
    }
}
