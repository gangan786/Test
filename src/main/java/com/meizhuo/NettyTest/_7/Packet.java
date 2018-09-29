package com.meizhuo.NettyTest._7;

import lombok.Data;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._7
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/9/29 13:11
 * @UpdateUser:
 * @UpdateDate: 2018/9/29 13:11
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */

@Data
public abstract class Packet {

    /**
     * 协议版本
     */
    private Byte version = 1;

    /**
     * @return 获取指令
     */
    public abstract Byte getCommand();

}
