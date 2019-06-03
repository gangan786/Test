package com.meizhuo.encryption;

import org.junit.Test;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname RSACoder
 * @Description RSA非对称加密
 * @Date 2019/6/3 11:54
 * @Created by Gangan
 */
public class RSACoder extends Coder {

    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey) throws Exception {
        //解密由BASE64编码的私钥
        byte[] keyBytes = decryptBASE64(privateKey);
        //构建PKCS8EncoderKeySpec
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        //指定加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //获取私钥对象
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        //用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(priKey);
        signature.update(data);
        return encryptBASE64(signature.sign());
    }

    /**
     * 校验数字签名
     *
     * @param data      加密数据
     * @param publicKey 公钥
     * @param sign      数字签名
     * @return
     * @throws Exception
     */
    public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {
        //解密由base64编码的公钥
        byte[] pubKeyBytes = decryptBASE64(publicKey);
        //构建X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubKeyBytes);
        // KEY_ALGORITHM指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //取公钥对象
        PublicKey pubKey = keyFactory.generatePublic(keySpec);

        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(pubKey);
        signature.update(data);
        return signature.verify(decryptBASE64(sign));
    }

    /**
     * 用私钥解密
     *
     * @param data
     * @param priKeyStr
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data, String priKeyStr) throws Exception {
        byte[] priKeyBytes = decryptBASE64(priKeyStr);

        //取得私钥
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(priKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        //对数据进行解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 使用公钥解密
     *
     * @param data
     * @param pubKeyStr
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data, String pubKeyStr) throws Exception {
        byte[] pubKeyBytes = decryptBASE64(pubKeyStr);

        //取得公钥
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(pubKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);

        //对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 使用公钥对数据进行加密
     *
     * @param data
     * @param pubKeyStr
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String pubKeyStr) throws Exception {
        //对公钥进行还原
        byte[] pubKeyBytes = decryptBASE64(pubKeyStr);
        //取得公钥
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubKeyBytes);
        KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = factory.generatePublic(keySpec);
        //对数据进行加密
        Cipher cipher = Cipher.getInstance(factory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        return cipher.doFinal(data);
    }

    /**
     * 使用私钥对数据进行加密
     *
     * @param data
     * @param priKeyStr
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String priKeyStr) throws Exception {
        //对私钥进行还原
        byte[] priKeyBytes = decryptBASE64(priKeyStr);
        //取得私钥
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(priKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        //加密数据
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(data);
    }

    /**
     * 取得私钥
     *
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return encryptBASE64(key.getEncoded());
    }

    /**
     * 取得公钥
     *
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return encryptBASE64(key.getEncoded());
    }

    /**
     * 初始化秘钥
     *
     * @return
     * @throws Exception
     */
    public static Map<String, Object> initKey() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        //指定秘钥长度大小
        generator.initialize(1024);
        KeyPair keyPair = generator.generateKeyPair();

        //公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        //私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;

    }

    @Test
    public void testRSATrance() throws Exception {
        //初始化公私钥
        Map<String, Object> keyMap = RSACoder.initKey();
        String publicKey = RSACoder.getPublicKey(keyMap);
        String privateKey = RSACoder.getPrivateKey(keyMap);

        System.out.println("The public Key is " + publicKey);
        System.out.println("The private Key is " + privateKey);

        System.out.println("公钥加密--私钥解密");

        String input="跟你分开的第十二个小时差15分钟" +
                "我好想你";
        byte[] encryptData = RSACoder.encryptByPublicKey(input.getBytes(), publicKey);
        byte[] decryptData = RSACoder.decryptByPrivateKey(encryptData, privateKey);

        String output = new String(decryptData);
        System.out.println("加密前的数据为：" + input + "\n解密后的数据为：" + output);

    }

    @Test
    public void testRSASign() throws Exception {
        //初始化公私钥
        Map<String, Object> keyMap = RSACoder.initKey();
        String publicKey = RSACoder.getPublicKey(keyMap);
        String privateKey = RSACoder.getPrivateKey(keyMap);

        System.out.println("The public Key is " + publicKey);
        System.out.println("The private Key is " + privateKey);

        System.out.println("私钥加密--公钥解密");
        String input="跟你分开的第十二个小时差15分钟" +
                "我好想你";
        byte[] encryptData = RSACoder.encryptByPrivateKey(input.getBytes(), privateKey);
        byte[] decryptData= RSACoder.decryptByPublicKey(encryptData, publicKey);
        System.out.println("加密前：" + input + "\n解密后：" + new String(decryptData));

        System.out.println("私钥签名--公钥验证签名");
        //产生签名
        String sign = RSACoder.sign(encryptData, privateKey);
        System.out.println("签名为：" + sign);

        //验证签名
        boolean verify = RSACoder.verify(encryptData, publicKey, sign);
        System.out.println("验证结果为：" + verify);
    }

}
