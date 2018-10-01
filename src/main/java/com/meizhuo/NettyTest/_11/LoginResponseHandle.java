package com.meizhuo.NettyTest._11;

import com.meizhuo.NettyTest._7.LoginRequestPacket;
import com.meizhuo.NettyTest._7.Packet;
import com.meizhuo.NettyTest._7.PacketCodeC;
import com.meizhuo.NettyTest._8.LoginResponsePacket;
import com.meizhuo.NettyTest._9.LoginUtil;
import com.meizhuo.NettyTest._9.MessageResponsePacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;
import java.util.UUID;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._11
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/1 12:07
 * @UpdateUser:
 * @UpdateDate: 2018/10/1 12:07
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class LoginResponseHandle extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date()+":  客户端开始登陆");

        //创建登陆对象
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUserName("Gangan");
        loginRequestPacket.setPassword("gangan");

        //写数据
        ctx.channel().writeAndFlush(loginRequestPacket);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket msg) throws Exception {

        if (msg.isSuccess()) {
            System.out.println(new Date() + ": 客户端登录成功");
            LoginUtil.markAsLogin(ctx.channel());
        } else {
            System.out.println(new Date() + ": 客户端登录失败，原因：" + msg.getReason());
        }
    }
}
