package com.meizhuo.NettyTest._8;

import com.meizhuo.NettyTest._7.LoginRequestPacket;
import com.meizhuo.NettyTest._7.Packet;
import com.meizhuo.NettyTest._7.PacketCodeC;
import com.meizhuo.NettyTest._9.LoginUtil;
import com.meizhuo.NettyTest._9.MessageRequestPacket;
import com.meizhuo.NettyTest._9.MessageResponsePacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

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
        ByteBuf requestByteBuf = (ByteBuf) msg;

        //解码
        Packet packet = PacketCodeC.INSTANT.decode(requestByteBuf);

        //判断是否是登录请求数据包
        if (packet instanceof LoginRequestPacket) {
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;

            LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
            loginResponsePacket.setVersion(packet.getVersion());

            //登录校验
            if (valid(loginRequestPacket)) {
                loginResponsePacket.setReason("登录成功");
                loginResponsePacket.setSuccess(true);
            } else {
                loginResponsePacket.setSuccess(false);
                loginResponsePacket.setReason("账号或者密码错误");
            }
            ByteBuf response = PacketCodeC.INSTANT.encode(ctx.alloc(), loginResponsePacket);
            ctx.writeAndFlush(response);
        } else if (packet instanceof MessageRequestPacket) {
            //处理消息
            MessageRequestPacket requestPacket = (MessageRequestPacket) packet;
            System.out.println(new Date() + " :收到客户端信息:  " + requestPacket.getMessage());
            MessageResponsePacket responsePacket = new MessageResponsePacket();
            responsePacket.setMessage("服务端回复【" + requestPacket.getMessage() + "】");
            ByteBuf encode = PacketCodeC.INSTANT.encode(ctx.alloc(), responsePacket);
            ctx.channel().writeAndFlush(encode);
        }


    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return "Gangan".equals(loginRequestPacket.getUserName())
                && "gangan".equals(loginRequestPacket.getPassword());
    }
}
