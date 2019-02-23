package com.meizhuo.DesignPatterns.FunnyDesignPatterns_19_组合模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_19_组合模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/23 11:28
 * @UpdateUser:
 * @UpdateDate: 2019/2/23 11:28
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class StringUtils {
    public static String fixedLength(char b, int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(b);
        }
        return builder.toString();
    }
}
