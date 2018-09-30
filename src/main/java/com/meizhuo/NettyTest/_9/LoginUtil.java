package com.meizhuo.NettyTest._9;

import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._9
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/9/30 17:21
 * @UpdateUser:
 * @UpdateDate: 2018/9/30 17:21
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class LoginUtil {
    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);

        return loginAttr.get() != null;
    }
}
