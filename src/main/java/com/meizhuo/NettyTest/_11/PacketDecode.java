package com.meizhuo.NettyTest._11;

import com.meizhuo.NettyTest._7.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._11
 * @ClassName: ${TYPE_NAME}
 * @Description: 把二进制转化成java对象
 * @Author: Gangan
 * @CreateDate: 2018/10/1 11:13
 * @UpdateUser:
 * @UpdateDate: 2018/10/1 11:13
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class PacketDecode extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        out.add(PacketCodeC.INSTANT.decode(in));
    }
}
