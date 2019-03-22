package com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂.example;

import com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂.Blocker;
import com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂.ConditionVarBlocker;
import com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂.GuardedAction;
import com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂.Predicate;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;


/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_2_保护性暂挂.test
 * @ClassName: ${TYPE_NAME}
 * @Description: 示范嵌套监视器锁死
 * @Author: Gangan
 * @CreateDate: 2019/3/22 20:41
 * @UpdateUser:
 * @UpdateDate: 2019/3/22 20:41
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class NestedMonitorLockoutExample {

    public static void main(String[] args) {

        final Helper helper = new Helper();

        System.out.println("Before calling guaredMethod");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String result;
                result = helper.xGuarededMethod("test");
                System.out.println(result);
            }
        });

        thread.start();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                helper.xStateChanged();
                timer.cancel();
            }
        }, 50, 10);

    }

    private static class Helper {
        private volatile boolean isStateOK = false;
        private final Predicate stateOk = new Predicate() {
            @Override
            public boolean evaluate() {
                return isStateOK;
            }
        };

        private final Blocker blocker = new ConditionVarBlocker();

        private synchronized String xGuarededMethod(final String message) {

            GuardedAction<String> ga = new GuardedAction<String>(stateOk) {
                @Override
                public String call() throws Exception {
                    return message + " --> received";
                }
            };

            String result = null;
            try {
                result = blocker.callWithGuard(ga);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return result;

        }

        public synchronized void xStateChanged() {
            try {
                blocker.singleAfter(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        isStateOK = true;
                        System.out.println("state OK");
                        return Boolean.TRUE;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
