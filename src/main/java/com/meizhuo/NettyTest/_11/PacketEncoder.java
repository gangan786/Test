package com.meizhuo.NettyTest._11;

import com.meizhuo.NettyTest._7.Packet;
import com.meizhuo.NettyTest._7.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._11
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/1 11:53
 * @UpdateUser:
 * @UpdateDate: 2018/10/1 11:53
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet msg, ByteBuf out) throws Exception {
        PacketCodeC.INSTANT.encode(out,msg);
    }
}
