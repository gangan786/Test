package com.meizhuo.DesignPatterns.ConcurrencyDP_8_串行线程封闭.e1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Classname ReusableCodeExample
 * @Description 测试串行封闭线程代码
 * @Date 2019/6/9 21:21
 * @Created by Gangan
 */
public class ReusableCodeExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SomeService ss = new SomeService();
        ss.init();
        Future<String> result = ss.doSomething("Serial Thread Confinement", 1);
        // 模拟执行其他操作
        Thread.sleep(4000);

        System.out.println(result.get());

        ss.shutdown();
    }

    private static class Task {
        public final String message;
        public final int id;

        public Task(String message, int id) {
            this.id = id;
            this.message = message;
        }
    }

    private static class SomeService extends AbstractSerializer<Task, String> {

        public SomeService() {
            super(new ArrayBlockingQueue<>(100),
                    new TaskProcessor<Task, String>() {
                        @Override
                        public String doProcess(Task task) throws Exception {
                            System.out.println("[" + task.id + "]:" + task.message);
                            return task.message + " accepted.";
                        }
                    });
        }

        @Override
        protected Task makeTask(Object... params) {
            String message = (String) params[0];
            int id = (Integer) params[1];
            return new Task(message, id);
        }

        public Future<String> doSomething(String message, int id) throws InterruptedException {
            Future<String> result = null;
            result = service(message, id);
            return result;
        }
    }


}
