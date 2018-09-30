package com.meizhuo.NettyTest._8;

import com.meizhuo.NettyTest._7.LoginRequestPacket;
import com.meizhuo.NettyTest._7.Packet;
import com.meizhuo.NettyTest._7.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;
import java.util.UUID;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._8
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/9/30 13:16
 * @UpdateUser:
 * @UpdateDate: 2018/9/30 13:16
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class ClientHandle extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date()+":  客户端开始登陆");

        //创建登陆对象
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUserName("Gangan");
        loginRequestPacket.setPassword("gangan");

        //编码
        ByteBuf buff = PacketCodeC.INSTANT.encode(ctx.alloc(), loginRequestPacket);

        //写数据
        ctx.channel().writeAndFlush(buff);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf= (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANT.decode(byteBuf);

        if (packet instanceof LoginRequestPacket){
            LoginRequestPacket loginRequestPacket= (LoginRequestPacket) packet;
            if (loginRequestPacket.isSuccess()){
                System.out.println(loginRequestPacket.getUserName()+loginRequestPacket.getReason());
            }else {
                System.out.println("登录失败"+loginRequestPacket.getReason());
            }
        }
    }
}
