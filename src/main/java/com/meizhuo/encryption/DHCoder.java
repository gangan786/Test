package com.meizhuo.encryption;

import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname DHCoder
 * @Description DH安全编码组件
 * @Date 2019/6/4 9:38
 * @Created by Gangan
 */
public class DHCoder extends Coder {

    public static final String ALGORITHM = "DH";

    /**
     * 默认密钥字节数
     */
    private static final int KEY_SIZE = 1024;
    /**
     * DH加密下需要一种对称加密算法对数据进行加密
     * 这里使用 DES
     */
    public static final String SECRET_ALGORITHM = "DES";
    private static final String PUBLIC_KEY = "DHPublicKey";
    private static final String PRIVATE_KEY = "DHPrivateKey";

    /**
     * 初始化甲方密钥
     *
     * @return
     * @throws Exception
     */
    public static Map<String, Object> initKey() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(KEY_SIZE);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        //甲方公钥
        PublicKey publicKey = keyPair.getPublic();
        //甲方私钥
        PrivateKey privateKey = keyPair.getPrivate();
        HashMap<String, Object> keyMap = new HashMap<>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    /**
     * 初始化乙方密钥
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static Map<String, Object> initKey(String key) throws Exception {
        //解析甲方公钥
        byte[] keyBytes = decryptBASE64(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        PublicKey aliePublicKey = keyFactory.generatePublic(keySpec);

        //由甲方公钥构建乙方密钥
        DHParameterSpec dhParameterSpec = ((DHPublicKey) aliePublicKey).getParams();

        KeyPairGenerator generator = KeyPairGenerator.getInstance(keyFactory.getAlgorithm());
        generator.initialize(dhParameterSpec);
        KeyPair keyPair = generator.generateKeyPair();

        //乙方公钥
        PublicKey publicKey = keyPair.getPublic();
        //乙方私钥
        PrivateKey privateKey = keyPair.getPrivate();
        HashMap<String, Object> keymap = new HashMap<>(2);
        keymap.put(PUBLIC_KEY, publicKey);
        keymap.put(PRIVATE_KEY, privateKey);
        return keymap;
    }

    /**
     * 加密
     *
     * @param data
     * @param publicKey  甲方公钥
     * @param privateKey 乙方私钥
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, String publicKey, String privateKey) throws Exception {
        //生成本地密钥
        SecretKey secretKey = getSecretKey(publicKey, privateKey);
        //数据加密
        Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }

    /**
     * @param data
     * @param publicKey  乙方公钥
     * @param privateKey 乙方私钥
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, String publicKey, String privateKey) throws Exception {
        SecretKey secretKey = getSecretKey(publicKey, privateKey);
        Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }


    /**
     * 构建密钥
     *
     * @param publicKeyStr  公钥
     * @param privateKeyStr 私钥
     * @return
     * @throws Exception
     */
    private static SecretKey getSecretKey(String publicKeyStr, String privateKeyStr) throws Exception {
        //初始化公钥
        byte[] pubKeyBytes = decryptBASE64(publicKeyStr);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(pubKeyBytes);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);

        //初始化私钥
        byte[] priKeyBytes = decryptBASE64(privateKeyStr);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(priKeyBytes);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

        //开始构建本地密钥
        KeyAgreement keyAgreement = KeyAgreement.getInstance(keyFactory.getAlgorithm());
        keyAgreement.init(privateKey);
        keyAgreement.doPhase(publicKey, true);

        //生成本地密钥
        SecretKey secretKey = keyAgreement.generateSecret(SECRET_ALGORITHM);
        return secretKey;
    }

    /**
     * 取得私钥
     *
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
        PrivateKey privateKey = (PrivateKey) keyMap.get(PRIVATE_KEY);
        return encryptBASE64(privateKey.getEncoded());
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

    @Test
    public void testDHCoder() throws Exception {
        //生成甲方密钥对
        Map<String, Object> alienKeyMap = DHCoder.initKey();
        String alienPublicKey = DHCoder.getPublicKey(alienKeyMap);
        String alienPrivateKey = DHCoder.getPrivateKey(alienKeyMap);

        System.out.println("甲方公钥为：" + alienPublicKey);
        System.out.println("甲方私钥为：" + alienPrivateKey);

        //由甲方公钥产生的用于乙方的密钥对
        Map<String, Object> baoKeyMap = DHCoder.initKey(alienPublicKey);
        String baoPublicKey = DHCoder.getPublicKey(baoKeyMap);
        String baoPrivateKey = DHCoder.getPrivateKey(baoKeyMap);

        String input = "喜欢秋风渐起的凉意,喜欢你喜欢的一切";
        System.out.println("原文为：" + input);

        //由甲方公钥，乙方私钥构建密文
        byte[] encrypt = DHCoder.encrypt(input.getBytes(), alienPublicKey, baoPrivateKey);

        //由乙方公钥，甲方私钥解密
        byte[] decrypt = DHCoder.decrypt(encrypt, baoPublicKey, alienPrivateKey);

        System.out.println("解密结果为：" + new String(decrypt));


    }

}
