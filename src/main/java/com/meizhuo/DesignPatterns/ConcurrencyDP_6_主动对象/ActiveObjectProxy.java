package com.meizhuo.DesignPatterns.ConcurrencyDP_6_主动对象;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @Classname ActiveObjectProxy
 * @Description TODO
 * @Date 2019/4/2 20:59
 * @Created by Gangan
 */
public class ActiveObjectProxy {

    /**
     * 生成一个实现指定接口的Active Object proxy实例。
     * 对interf所定义的异步方法的调用会被转发到servant的相应doXXX方法。
     * 为泛型方法
     *
     * @param interf 要实现的Active Object接口
     * @param servant Active Object的Servant参与者实例(真正的执行体)
     * @param scheduler Active Object的Scheduler参与者实例
     * @return Active Object的Proxy参与者实例
     */
    public static <T> T newInstance(Class<T> interf, Object servant,
                                    ExecutorService scheduler) {

        @SuppressWarnings("unchecked")
        T f = (T) Proxy.newProxyInstance(interf.getClassLoader(),
                new Class[] { interf },
                new DispatchInvocationHandler(servant, scheduler));
        return f;
    }
}

class DispatchInvocationHandler implements InvocationHandler {
    /**
     * 真正的执行体
     */
    private final Object delegate;
    /**
     * 线程池
     */
    private final ExecutorService scheduler;

    public DispatchInvocationHandler(Object delegate,
                                     ExecutorService executorService) {
        this.delegate = delegate;
        this.scheduler = executorService;
    }

    private String makeDelegateMethodName(final Method method,
                                          final Object[] arg) {
        String name = method.getName();
        name = "do" + Character.toUpperCase(name.charAt(0)) + name.substring(1);

        return name;
    }

    /**
     *
     * @param proxy 代理对象，在本例子中指的是SampleActiveObjectImplement实例
     * @param method 调用的接口方法，在本例子中指的是SampleActiveObject中的process()
     * @param args process()方法中对应的参数
     * @return 处理完毕后，代理方法的返回值，在本例子中指的是process()对应的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(final Object proxy, final Method method,
                         final Object[] args) throws Throwable {

        Object returnValue = null;
        final Object delegate = this.delegate;
        final Method delegateMethod;

        // 如果拦截到的被调用方法是异步方法，则将其转发到相应的doXXX方法
        if (Future.class.isAssignableFrom(method.getReturnType())) {
            //获取实现类中对应的实现方法
            delegateMethod = delegate.getClass().getMethod(
                    makeDelegateMethodName(method, args),
                    method.getParameterTypes());

            final ExecutorService scheduler = this.scheduler;

            Callable<Object> methodRequest = new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    Object rv = null;
                    try {
                        //在线程池中调用真正的实现方法执行
                        rv = delegateMethod.invoke(delegate, args);
                    } catch (IllegalArgumentException | IllegalAccessException
                            | InvocationTargetException e) {
                        throw new Exception(e);
                    }
                    //返回值会封装在future中
                    return rv;
                }
            };
            Future<Object> future = scheduler.submit(methodRequest);
            returnValue = future;

        } else {

            // 若拦截到的方法调用不是异步方法，则直接转发
            delegateMethod = delegate.getClass().getMethod(method.getName(),
                    method.getParameterTypes());
            returnValue = delegateMethod.invoke(delegate, args);
        }

        return returnValue;
    }

    public static void main(String[] args) {
        
    }

}
