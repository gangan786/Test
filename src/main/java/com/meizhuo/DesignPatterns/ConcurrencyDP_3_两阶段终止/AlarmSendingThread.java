package com.meizhuo.DesignPatterns.ConcurrencyDP_3_两阶段终止;

import com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂.AlarmAgent;
import com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂.AlarmInfo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_3_两阶段终止
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/24 21:16
 * @UpdateUser:
 * @UpdateDate: 2019/3/24 21:16
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class AlarmSendingThread extends AbstractTerminatableThread {

    private final AlarmAgent alarmAgent = new AlarmAgent();

    /**
     * 告警队列，线程不断从这个队列中取出告警信息进行发送
     */
    private final BlockingQueue<AlarmInfo> alarmQueue;
    /**
     * 记录所有用户提交的告警记录
     * AtomicInteger 记录的是同一类型告警信息提交的次数
     */
    private final ConcurrentMap<String, AtomicInteger> submittedAlarmRegistry;

    public AlarmSendingThread() {
        alarmQueue = new LinkedBlockingQueue<>(100);
        submittedAlarmRegistry = new ConcurrentHashMap<>();
        alarmAgent.init();
    }

    @Override
    protected void doRun() throws Exception {
        AlarmInfo alarmInfo;
        //如果队列为空则阻塞直到不为空
        alarmInfo = alarmQueue.take();
        //发送告警消息后减一
        terminationToken.reservations.decrementAndGet();
        try {
            alarmAgent.sendAlarm(alarmInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 处理恢复告警：将相应的故障告警从注册表中删除，使得相应故障恢复后若再次出现相同故障
         * 该故障信息能够上报到服务器
         */
        if (alarmInfo.getType() == 1) {
            String key = "2" + alarmInfo.getTime() + ":" + alarmInfo.getMessage() + ":" + alarmInfo.getType();
            submittedAlarmRegistry.remove(key);
            key = "1" + alarmInfo.getTime() + ":" + alarmInfo.getMessage() + ":" + alarmInfo.getType();
            submittedAlarmRegistry.remove(key);
        }


    }

    /**
     * 将告警消息插入队列中
     * @param alarmInfo 告警信息
     * @return
     */
    public int sendAlarm(final AlarmInfo alarmInfo) {
        if (terminationToken.isToShutdown()) {
            //记录告警
            System.out.println(alarmInfo);
            return -1;
        }

        int duplicateSubmissionCount = 0;
        try {
            AtomicInteger prevSubmittedCounter;

            prevSubmittedCounter = submittedAlarmRegistry
                    .putIfAbsent(alarmInfo.getTime() + ":" + alarmInfo.getMessage() + ":" + alarmInfo.getType()
                            , new AtomicInteger(0));
            if (null == prevSubmittedCounter) {
                //表示新接到一个告警消息
                terminationToken.reservations.incrementAndGet();
                alarmQueue.put(alarmInfo);
            } else {
                //故障未恢复，不用重复发送告警信息给服务器，故仅增加计数
                duplicateSubmissionCount = prevSubmittedCounter.incrementAndGet();
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return duplicateSubmissionCount;

    }

    @Override
    /**
     * 停止目标线程做一些其他必要的操作
     */
    protected void doTerminiate() {
        System.out.println("子类停止调用");
    }

    @Override
    /**
     * 线程停止后的清理工作
     */
    protected void doCleanup(Exception cause) {
        if (null != cause && !(cause instanceof InterruptedException)) {
            cause.printStackTrace();
        }
        alarmAgent.disconnect();
    }
}
