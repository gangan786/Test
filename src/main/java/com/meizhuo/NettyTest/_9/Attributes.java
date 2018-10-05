package com.meizhuo.NettyTest._9;


import com.meizhuo.NettyTest._15.Session;
import io.netty.util.AttributeKey;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._9
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/9/30 17:14
 * @UpdateUser:
 * @UpdateDate: 2018/9/30 17:14
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");

}
