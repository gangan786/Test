package com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/21 14:25
 * @UpdateUser:
 * @UpdateDate: 2019/3/21 14:25
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class AlarmAgent {

    /**
     * 用于记录AlarmAgent是否连接上告警服务器
     */
    private volatile boolean connectedToServer = false;

    private final Blocker blocker = new ConditionVarBlocker();

    private final Timer heartbeatTimer = new Timer(true);

    private final Predicate agentConnected = new Predicate() {
        @Override
        public boolean evaluate() {
            return connectedToServer;
        }
    };

    /**
     * 暴露接口发送告警消息
     *
     * @param alarmInfo
     * @throws Exception
     */
    public void sendAlarm(final AlarmInfo alarmInfo) throws Exception {
        //可能需要等待，知道AlarmAgent连上告警服务器（或者连接中断后重新连上服务器）
        GuardedAction<Void> guardedAction = new GuardedAction<Void>(agentConnected) {
            /**
             * 连接正常之后的调用
             * @return 此方法的返回值决定了下行代码 blocker.callWithGuard(guardedAction) 的返回值
             * @throws Exception
             */
            @Override
            public Void call() throws Exception {
                doSendAlarm(alarmInfo);
                return null;
            }
        };
        blocker.callWithGuard(guardedAction);
    }

    /**
     * 通过网络连接将 告警信息发 送给 告警服务器
     *
     * @param alarmInfo
     */
    private void doSendAlarm(AlarmInfo alarmInfo) {
        System.out.println("sending alarm " + alarmInfo);
    }

    public void init() {

        //启动告警连接线程
        Thread connectingThread = new Thread(new ConnectingTask());
        connectingThread.start();

        //启动心跳检测线程
        heartbeatTimer.schedule(new HeartbeatTask(), 60000, 2000);

    }

    public void disconnect() {
        System.out.println("disconnected from alarm server");
        connectedToServer = false;
    }

    /**
     * 唤醒因连接而等待的sendAlarm方法线程
     * 实际连接成功之后调用这个办法更改状态
     */
    protected void onConnected() {
        try {
            /**
             * 在本案例中的sendAlarm方法由专门的一个线程调用，
             * 因此这里唤醒被暂挂的sendAlarm方法执行线程时，
             * 调用singleAfter方法即可，
             * 而无需调用broadcastAfter方法
             */
            blocker.singleAfter(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    connectedToServer = true;
                    System.out.println("connected to server");
                    return Boolean.TRUE;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onDisConnected() {
        connectedToServer = false;
    }


    /**
     * 负责与告警服务器建立网络连接
     */
    private class ConnectingTask implements Runnable {

        @Override
        public void run() {

            //模拟连接操作耗时
            try {
                //这里进行的是实际的网络连接
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //连接成功，恢复唤醒sendAlarm方法的执行线程
            onConnected();
        }
    }

    /**
     * 心跳定时任务：定时检查与告警服务器的连接是否正常，发现连接异常后自动重新连接
     */
    private class HeartbeatTask extends TimerTask {

        @Override
        public void run() {
            if (!testConnection()) {
                //检测连接失败尝试重连
                onDisConnected();
                reconnect();
            }
        }

        private void reconnect() {
            ConnectingTask connectingTask = new ConnectingTask();

            //直接在心跳定时器线程中执行
            connectingTask.run();
        }

        /**
         * 检测连接的可用性
         * @return
         */
        private boolean testConnection() {
            return true;
        }


    }

}
