package com.meizhuo.NettyTest._13;

import com.meizhuo.NettyTest._9.LoginUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._13
 * @ClassName: ${TYPE_NAME}
 * @Description: 用于用户登录认证操作
 * @Author: Gangan
 * @CreateDate: 2018/10/3 21:38
 * @UpdateUser:
 * @UpdateDate: 2018/10/3 21:38
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@ChannelHandler.Sharable
public class AuthHandler extends ChannelInboundHandlerAdapter {

    public static final AuthHandler INSTANCE = new AuthHandler();

    private AuthHandler() {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (LoginUtil.hasLogin(ctx.channel())) {
            //验证通过后直接移除此Handle，以免每次都要判断造成资源的浪费
            ctx.pipeline().remove(this);
            super.channelRead(ctx, msg);
        } else {
            ctx.channel().close();
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        if (LoginUtil.hasLogin(ctx.channel())) {
            System.out.println("当前连接登录验证完毕，无需再次验证，AuthHandler被移除");
        } else {
            System.out.println("登录验证失败，强制关闭连接");
        }
    }
}
