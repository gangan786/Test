package com.meizhuo.NettyTest._11;

import com.meizhuo.NettyTest._7.LoginRequestPacket;
import com.meizhuo.NettyTest._7.PacketCodeC;
import com.meizhuo.NettyTest._8.LoginResponsePacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

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
            } else {
                loginResponsePacket.setReason("账号或者密码错误");
                loginResponsePacket.setSuccess(false);
            }

            ctx.channel().writeAndFlush(loginResponsePacket);

    }

    private boolean valid(LoginRequestPacket msg) {
        return "Gangan".equals(msg.getUserName())
                && "gangan".equals(msg.getPassword());
    }
}
