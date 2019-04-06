package com.meizhuo.DesignPatterns.ConcurrencyDP_7_线程特有存储;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @Classname ThreadSpecificSecureRandom
 * @Description TODO
 * @Date 2019/4/6 10:53
 * @Created by Gangan
 */
public class ThreadSpecificSecureRandom {

    public static final ThreadSpecificSecureRandom INSTANCE = new ThreadSpecificSecureRandom();

    private static final ThreadLocal<SecureRandom> SECURE_RANDOM = new ThreadLocal<SecureRandom>() {
        /**
         * init方法只会在线程中的ThreadLocalMap还没有实例化的时候调用
         * 且每个线程仅调用一次，
         * 所以对于每个线程中SecureRandom实例都是不同的
         * @return
         */
        @Override
        protected SecureRandom initialValue() {
            SecureRandom secureRandom;
            try {
                secureRandom = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                secureRandom = new SecureRandom();
            }
            return secureRandom;
        }
    };

    private ThreadSpecificSecureRandom() {

    }

    /**
     * 多线程并发调用此方法获取强随机数
     * @param upperBound
     * @return
     */
    public int nextInt(int upperBound) {
        SecureRandom secureRnd = SECURE_RANDOM.get();
        return secureRnd.nextInt(upperBound);
    }

    public void setSeed(long seed) {
        SecureRandom secureRnd = SECURE_RANDOM.get();
        secureRnd.setSeed(seed);
    }


}
