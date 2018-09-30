package com.meizhuo.NettyTest._8;

import com.meizhuo.NettyTest._7.LoginRequestPacket;
import com.meizhuo.NettyTest._7.Packet;
import com.meizhuo.NettyTest._7.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._8
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/9/30 13:50
 * @UpdateUser:
 * @UpdateDate: 2018/9/30 13:50
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class ServiceHandle extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf requestByteBuf= (ByteBuf) msg;

        //解码
        Packet packet = PacketCodeC.INSTANT.decode(requestByteBuf);

        //判断是否是登录请求数据包
        if (packet instanceof LoginRequestPacket){
            LoginRequestPacket loginRequestPacket= (LoginRequestPacket) packet;
            //登录校验
            if (valid(loginRequestPacket)){
                loginRequestPacket.setReason("登录成功");
                loginRequestPacket.setSuccess(true);
            }else {
                loginRequestPacket.setSuccess(false);
                loginRequestPacket.setReason("账号或者密码错误");
            }
            ByteBuf response = PacketCodeC.INSTANT.encode(ctx.alloc(), loginRequestPacket);
            ctx.writeAndFlush(response);
        }


    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return "Gangan".equals(loginRequestPacket.getUserName())
                &&"gangan".equals(loginRequestPacket.getPassword());
    }
}
