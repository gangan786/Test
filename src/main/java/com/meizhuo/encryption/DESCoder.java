package com.meizhuo.encryption;

import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;

/**
 * @Classname DESCoder
 * @Description TODO
 * @Date 2019/5/31 19:56
 * @Created by Gangan
 */
public class DESCoder extends Coder {

    public static final String ALGORITHM="DES";

    /**
     * 秘钥转换
     * @param key
     * @return
     * @throws Exception
     */
    public static Key toKey(byte[] key) throws Exception {
        DESKeySpec keySpec = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey secretKey = keyFactory.generateSecret(keySpec);
        return secretKey;
    }

    /**
     * 解密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, String key) throws Exception {
        Key k = toKey(decryptBASE64(key));

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, k);

        return cipher.doFinal(data);
    }

    /**
     * 加密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, String key) throws Exception {
        Key k = toKey(decryptBASE64(key));
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, k);

        return cipher.doFinal(data);
    }

    /**
     * 生成秘钥
     * @param seed
     * @return
     * @throws Exception
     */
    public static String initKey(String seed) throws Exception {
        SecureRandom secureRandom = null;

        if (seed != null) {
            secureRandom = new SecureRandom(decryptBASE64(seed));
        } else {
            secureRandom = new SecureRandom();
        }

        KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
        kg.init(secureRandom);

        SecretKey secretKey = kg.generateKey();

        return encryptBASE64(secretKey.getEncoded());
    }

    public static String initKey() throws Exception {
        return initKey(null);
    }

    @Test
    public void testDES() throws Exception {
        String inputContent="趣码社交会员制电商诚招合伙人: " +
                "一起来做一名优秀的地推员吧一起致富发家️ 推广一个" +
                "普通餐饮店商家给60块提成，" +
                "推广一个连锁餐饮商家给150块提成，还有更多奖励，" +
                "加入我们吧！了解详情请加趣码推广专员";
        String initKey = DESCoder.initKey();

        byte[] encrypt = DESCoder.encrypt(inputContent.getBytes(), initKey);
        System.out.println("原始数据为：" + inputContent);
        System.out.println("加密的数据为：" + new String(encrypt));
        byte[] decrypt = DESCoder.decrypt(encrypt, initKey);
        System.out.printf("解密后的数据为："+new String(decrypt));
    }

}
