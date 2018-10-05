package com.meizhuo.NettyTest._9;

import com.meizhuo.NettyTest._7.Command;
import com.meizhuo.NettyTest._7.Packet;
import lombok.Data;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._9
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/9/30 16:48
 * @UpdateUser:
 * @UpdateDate: 2018/9/30 16:48
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Data
public class MessageResponsePacket extends Packet {

    private String message;

    private String fromUserId;

    private String fromUserName;

    private String stateDes;

    private int code;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
