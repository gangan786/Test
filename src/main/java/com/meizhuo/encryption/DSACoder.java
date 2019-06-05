package com.meizhuo.encryption;

import org.junit.Test;

import java.security.*;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname DSACoder
 * @Description DSA 安全编码组件
 *              DSA 算法会根据数据内容以及私钥生成对应的签名
 *              这个签名对应了该数据内容，保证了数据内容不被篡改
 *              所以验证的时候，不仅要求公钥和签名
 *              而且要求对应的数据内容
 *              这三个参数共同保证了验证以及内容不被修改的算法承若
 * @Date 2019/6/5 13:50
 * @Created by Gangan
 */
public class DSACoder extends Coder {

    public static final String ALOGORITHM = "DSA";

    /**
     * 默认密钥字节数
     */
    private static final int KEY_SIZE = 1024;

    /**
     * 默认种子
     */
    private static final String DEFAULT_SEED = "ganganlovedondondforever1314000";

    private static final String PUBLIC_KEY = "PublicKey";
    private static final String PRIVADTE_KEY = "PrivateKey";

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data
     * @param privateKeyStr
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKeyStr) throws Exception {
        //还原私钥
        byte[] privateKeyBytes = decryptBASE64(privateKeyStr);
        //构建私钥
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory factory = KeyFactory.getInstance(ALOGORITHM);
        PrivateKey privateKey = factory.generatePrivate(keySpec);

        //用私钥生成数字签名
        Signature signature = Signature.getInstance(factory.getAlgorithm());
        signature.initSign(privateKey);
        signature.update(data);

        return encryptBASE64(signature.sign());
    }

    /**
     * 校验数字签名
     *
     * @param data
     * @param publicKeyStr
     * @param sign
     * @return
     * @throws Exception
     */
    public static boolean verify(byte[] data, String publicKeyStr, String sign) throws Exception {
        //还原公钥
        byte[] publicKeyBytes = decryptBASE64(publicKeyStr);
        //构建公钥
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory factory = KeyFactory.getInstance(ALOGORITHM);
        PublicKey publicKey = factory.generatePublic(keySpec);

        Signature signature = Signature.getInstance(factory.getAlgorithm());
        signature.initVerify(publicKey);
        signature.update(data);

        return signature.verify(decryptBASE64(sign));
    }

    /**
     * 构建密钥
     *
     * @param seed
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static Map<String, Object> initKey(String seed) throws NoSuchAlgorithmException {
        KeyPairGenerator pairGenerator = KeyPairGenerator.getInstance(ALOGORITHM);
        //初始化随机产生器
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(seed.getBytes());
        pairGenerator.initialize(KEY_SIZE, secureRandom);

        KeyPair keyPair = pairGenerator.genKeyPair();
        DSAPublicKey publicKey = (DSAPublicKey) keyPair.getPublic();
        DSAPrivateKey privateKey = (DSAPrivateKey) keyPair.getPrivate();

        HashMap<String, Object> keyMap = new HashMap<>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVADTE_KEY, privateKey);
        return keyMap;
    }

    /**
     * 构建默认密钥
     *
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static Map<String, Object> initKey() throws NoSuchAlgorithmException {
        return initKey(DEFAULT_SEED);
    }

    /**
     * 取得公钥
     *
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
        PublicKey publicKey = (PublicKey) keyMap.get(PUBLIC_KEY);
        return encryptBASE64(publicKey.getEncoded());
    }

    /**
     * 获取私钥
     *
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
        PrivateKey privateKey = (PrivateKey) keyMap.get(PRIVADTE_KEY);
        return encryptBASE64(privateKey.getEncoded());
    }

    @Test
    public void testDSACoder() throws Exception {
        String input="你心里有没有这样一个人，你喜欢他但又不敢打扰他。你想跟他说说话，" +
                "但又不敢明目张胆地告诉他。于是你就总是时不时跟他说一些无关紧要的话。" +
                "当然这些话其实也没有太多的意义，只是因为“我想你”，" +
                "无数句“在吗”“吃了吗”“你睡了吗”……都是“我想你”的意思";

        byte[] data = input.getBytes();
        //构建密钥
        Map<String, Object> keyMap = DSACoder.initKey();
        //获得密钥
        String publicKey = DSACoder.getPublicKey(keyMap);
        String privateKey = DSACoder.getPrivateKey(keyMap);

        //产生签名
        String sign = DSACoder.sign(data, privateKey);
        System.out.println("签名为：" + sign);

        //验证签名
        boolean verify = DSACoder.verify(data, publicKey, sign);

        System.out.println("状态为：" + verify);

    }

}
