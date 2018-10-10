package com.meizhuo.NettyTest._16.Packet;

import com.meizhuo.NettyTest._7.Command;
import com.meizhuo.NettyTest._7.Packet;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16.Packet
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/10 10:13
 * @UpdateUser:
 * @UpdateDate: 2018/10/10 10:13
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Data
@NoArgsConstructor
public class GroupMessageRequstPacket extends Packet {

    private String groupId;

    private String message;

    public GroupMessageRequstPacket(String groupId, String message) {
        this.groupId = groupId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.GROUP_MESSAGE_REQUEST;
    }
}
