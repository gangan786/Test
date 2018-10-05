package com.meizhuo.NettyTest._9;

import com.meizhuo.NettyTest._7.Command;
import com.meizhuo.NettyTest._7.Packet;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._9
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/9/30 15:04
 * @UpdateUser:
 * @UpdateDate: 2018/9/30 15:04
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Data
@NoArgsConstructor
public class MessageRequestPacket extends Packet {

    private String toUserId;

    private String message;

    public MessageRequestPacket(String toUserId, String message) {
        this.toUserId = toUserId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
