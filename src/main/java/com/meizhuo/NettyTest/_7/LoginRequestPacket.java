package com.meizhuo.NettyTest._7;

import lombok.Data;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._7
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/9/29 13:18
 * @UpdateUser:
 * @UpdateDate: 2018/9/29 13:18
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Data
public class LoginRequestPacket extends Packet {

    private String userId;

    private String userName;

    private String password;

    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
