package com.meizhuo.DesignPatterns.ConcurrencyDP_3_两阶段终止;

import com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂.AlarmInfo;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_3_两阶段终止
 * @ClassName: ${TYPE_NAME}
 * @Description: 告警功能入口类(单例)
 * @Author: Gangan
 * @CreateDate: 2019/3/24 21:11
 * @UpdateUser:
 * @UpdateDate: 2019/3/24 21:11
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class AlarmMgr {

    /**
     * 保存该功能类唯一实例
     */
    private static final AlarmMgr INSTANCE = new AlarmMgr();

    private volatile boolean shutdownRequest = false;

    /**
     * 告警发送线程
     */
    private final AlarmSendingThread alarmSendingThread;

    private AlarmMgr() {
        alarmSendingThread = new AlarmSendingThread();
    }

    /**
     * 返回AlarmMgr唯一实例
     *
     * @return
     */
    public static AlarmMgr getInstance() {
        return INSTANCE;
    }

    /**
     * 发送告警
     * @param alarmType
     * @param time
     * @param message
     * @return
     */
    public int sendAlarm(int alarmType, String time, String message) {
        int duplicateSubmissionCount = 0;
        try {
            AlarmInfo alarmInfo = new AlarmInfo();
            alarmInfo.setType(alarmType);
            alarmInfo.setTime(time);
            alarmInfo.setMessage(message);
            duplicateSubmissionCount = alarmSendingThread.sendAlarm(alarmInfo);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return duplicateSubmissionCount;
    }

    public void init() {
        alarmSendingThread.start();
    }

    public synchronized void shutdown() {
        if (shutdownRequest) {
            throw new IllegalStateException("shutdown already requested");
        }
        alarmSendingThread.terminate();
        shutdownRequest = true;
    }


}
