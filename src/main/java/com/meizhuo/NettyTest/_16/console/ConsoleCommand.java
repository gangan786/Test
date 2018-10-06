package com.meizhuo.NettyTest._16.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._16
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/6 14:28
 * @UpdateUser:
 * @UpdateDate: 2018/10/6 14:28
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public interface ConsoleCommand {

    void exec(Scanner scanner, Channel channel);

}
