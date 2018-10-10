package com.meizhuo.NettyTest._16.Packet;

import com.meizhuo.NettyTest._7.Command;
import com.meizhuo.NettyTest._7.Packet;
import lombok.Data;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.Packet
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/9 21:41
 * @UpdateUser:
 * @UpdateDate: 2018/10/9 21:41
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Data
public class ListGroupMembersRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {
        return Command.LIST_GROUP_MEMBERS_REQUEST;
    }
}
