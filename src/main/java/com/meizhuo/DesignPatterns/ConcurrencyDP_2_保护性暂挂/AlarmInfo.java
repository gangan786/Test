package com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/21 15:53
 * @UpdateUser:
 * @UpdateDate: 2019/3/21 15:53
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class AlarmInfo {

    private String time;

    private String message;

    public final String getTime() {
        return time;
    }

    public final void setTime(String time) {
        this.time = time;
    }

    public final String getMessage() {
        return message;
    }

    public final void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AlarmInfo{" +
                "time='" + time + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
