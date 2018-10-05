package com.meizhuo.NettyTest._15;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._15
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/5 19:51
 * @UpdateUser:
 * @UpdateDate: 2018/10/5 19:51
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@NoArgsConstructor
@Data
public class Session {
    private String userId;
    private String userName;

    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
