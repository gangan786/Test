package com.meizhuo.NettyTest._16.Packet;

import com.meizhuo.NettyTest._15.Session;
import com.meizhuo.NettyTest._7.Command;
import com.meizhuo.NettyTest._7.Packet;
import lombok.Data;

import java.util.List;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.Packet
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/9 21:52
 * @UpdateUser:
 * @UpdateDate: 2018/10/9 21:52
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String group;

    private List<Session> sessionList;

    @Override
    public Byte getCommand() {
        return Command.LIST_GROUP_MEMBERS_RESPONSE;
    }
}
