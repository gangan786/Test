package com.meizhuo.DesignPatterns.ConcurrencyDP_6_主动对象;

import java.util.concurrent.Future;

/**
 * @Classname SampleActiveObject
 * @Description TODO
 * @Date 2019/4/5 10:09
 * @Created by Gangan
 */
public interface SampleActiveObject {

    public Future<String> process(String arg,int i);

}
