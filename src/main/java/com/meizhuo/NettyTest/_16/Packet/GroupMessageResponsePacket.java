package com.meizhuo.NettyTest._16.Packet;

import com.meizhuo.NettyTest._15.Session;
import com.meizhuo.NettyTest._7.Command;
import com.meizhuo.NettyTest._7.Packet;
import lombok.Data;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.Packet
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/10 11:00
 * @UpdateUser:
 * @UpdateDate: 2018/10/10 11:00
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Data
public class GroupMessageResponsePacket extends Packet {

    private String fromGroupId;

    private Session fromUser;

    private String message;

    @Override
    public Byte getCommand() {
        return Command.GROUP_MESSAGE_RESPONSE;
    }
}
