package com.meizhuo.NettyTest._15;

import com.meizhuo.NettyTest._7.Command;
import com.meizhuo.NettyTest._7.Packet;
import lombok.Data;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._15
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/6 11:53
 * @UpdateUser:
 * @UpdateDate: 2018/10/6 11:53
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Data
public class ResponsePacket extends Packet {

    private String stateDes;

    private int code;

    @Override
    public Byte getCommand() {
        return Command.RESULT_MESSAGE_STATE;
    }
}
