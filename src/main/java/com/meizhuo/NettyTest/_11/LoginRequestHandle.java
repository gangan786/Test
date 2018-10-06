package com.meizhuo.NettyTest._11;

import com.meizhuo.NettyTest._15.Session;
import com.meizhuo.NettyTest._15.SessionUtil;
import com.meizhuo.NettyTest._7.LoginRequestPacket;
import com.meizhuo.NettyTest._7.PacketCodeC;
import com.meizhuo.NettyTest._8.LoginResponsePacket;
import com.meizhuo.NettyTest._9.LoginUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._11
 * @ClassName: ${TYPE_NAME}
 * @Description: 完成登录请求的牢记逻辑处理
 * @Author: Gangan
 * @CreateDate: 2018/10/1 11:23
 * @UpdateUser:
 * @UpdateDate: 2018/10/1 11:23
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class LoginRequestHandle extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket msg) throws Exception {


        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(msg.getVersion());

        //登录校验
        if (valid(msg)) {
            loginResponsePacket.setReason("登录成功");
            loginResponsePacket.setSuccess(true);
            //标记登录状态，是是否移除AuthHandle的依据
            LoginUtil.markAsLogin(ctx.channel());
            String userId=randomUserId();
            loginResponsePacket.setUserId(userId);
            loginResponsePacket.setUserName(msg.getUserName());

            //绑定channel
            SessionUtil.bindSession(new Session(userId,msg.getUserName()),ctx.channel());
            System.out.println("[ "+msg.getUserName()+" ]  登录成功");

        } else {
            loginResponsePacket.setReason("账号或者密码错误");
            loginResponsePacket.setSuccess(false);
        }

        ctx.channel().writeAndFlush(loginResponsePacket);

    }

    private String randomUserId() {
        return UUID.randomUUID().toString().split("-")[0];
    }

    private boolean valid(LoginRequestPacket msg) {
        return (("Gangan".equals(msg.getUserName())
                || "Dong".equals(msg.getUserName())
                ||"Shi".equals(msg.getUserName()))
                && "gangan".equals(msg.getPassword()));
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //取消绑定
        SessionUtil.unBindSession(ctx.channel());
    }
}
