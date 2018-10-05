package com.meizhuo.NettyTest._7;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._7
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/9/29 13:20
 * @UpdateUser:
 * @UpdateDate: 2018/9/29 13:20
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public interface Command {
    Byte LOGIN_REQUEST = 1;
    Byte LOGIN_RESPONSE=2;
    Byte MESSAGE_REQUEST = 3;
    Byte MESSAGE_RESPONSE = 4;

    Byte RESULT_MESSAGE_FAIL=5;
}
