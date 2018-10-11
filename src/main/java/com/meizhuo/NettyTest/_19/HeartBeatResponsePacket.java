package com.meizhuo.NettyTest._19;

import com.meizhuo.NettyTest._7.Command;
import com.meizhuo.NettyTest._7.Packet;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._19
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/11 14:33
 * @UpdateUser:
 * @UpdateDate: 2018/10/11 14:33
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class HeartBeatResponsePacket extends Packet {
    @Override
    public Byte getCommand() {
        return Command.HEARDBEAT_RESPONSE;
    }
}
