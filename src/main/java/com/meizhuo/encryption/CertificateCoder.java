package com.meizhuo.encryption;

import org.junit.Test;

import javax.crypto.Cipher;
import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.security.*;
import java.security.cert.*;
import java.security.cert.Certificate;
import java.util.Date;

/**
 * @Classname CertificateCoder
 * @Description 数字证书组件
 * @Date 2019/6/7 14:19
 * @Created by Gangan
 */
public class CertificateCoder extends Coder {

    /**
     * java密钥库
     */
    public static final String KEY_STORE = "JKS";

    public static final String X509 = "X.509";
    public static final String SUNX509="SunX509";
    public static final String SSL="SSL";

    /**
     * 由 keyStore 获得私钥
     *
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    private static PrivateKey getPrivateKey(String keyStorePath, String alias,
                                            String password) throws Exception {
        KeyStore keyStore = getKeyStore(keyStorePath, password);
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, password.toCharArray());
        return privateKey;
    }

    /**
     * 由 Certificate 数字证书获得公钥
     *
     * @param certificatePath
     * @return
     * @throws Exception
     */
    private static PublicKey getPublicKey(String certificatePath) throws Exception {
        Certificate certificate = getCertificate(certificatePath);
        PublicKey publicKey = certificate.getPublicKey();
        return publicKey;
    }

    /**
     * 通过 KeyStore 获得 Certificate 数字证书
     *
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    private static Certificate getCertificate(String keyStorePath,
                                              String alias,
                                              String password) throws Exception {
        KeyStore keyStore = getKeyStore(keyStorePath, password);
        Certificate certificate = keyStore.getCertificate(alias);
        return certificate;
    }

    /**
     * 获得 Certificate 数字证书
     *
     * @param certificatePath
     * @return
     * @throws Exception
     */
    private static Certificate getCertificate(String certificatePath) throws Exception {
        CertificateFactory factory = CertificateFactory.getInstance(X509);
        FileInputStream inputStream = new FileInputStream(certificatePath);
        Certificate certificate = factory.generateCertificate(inputStream);
        inputStream.close();
        return certificate;
    }

    /**
     * 获得KeyStore
     *
     * @param keyStorePath
     * @param password
     * @return
     * @throws Exception
     */
    private static KeyStore getKeyStore(String keyStorePath, String password) throws Exception {
        FileInputStream inputStream = new FileInputStream(keyStorePath);
        KeyStore keyStore = KeyStore.getInstance(KEY_STORE);
        keyStore.load(inputStream, password.toCharArray());
        inputStream.close();
        return keyStore;
    }

    /**
     * 私钥加密
     *
     * @param data
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String keyStorePath,
                                             String alias, String password) throws Exception {
        //取得私钥
        PrivateKey privateKey = getPrivateKey(keyStorePath, alias, password);
        //对数据进行加密
        Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 使用私钥解密
     *
     * @param data
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data, String keyStorePath,
                                             String alias, String password) throws Exception {
        //取得私钥
        PrivateKey privateKey = getPrivateKey(keyStorePath, alias, password);
        //对数据进行解密
        Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * 使用公钥加密
     *
     * @param data
     * @param certificatePath
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String certificatePath) throws Exception {
        //获取公钥
        PublicKey publicKey = getPublicKey(certificatePath);
        //对数据进行加密
        Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }


    /**
     * 使用公钥进行解密
     *
     * @param data
     * @param certificatePath
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data, String certificatePath) throws Exception {
        //获取公钥
        PublicKey publicKey = getPublicKey(certificatePath);
        //对数据进行解密
        Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 验证数字证书
     *
     * @param certificatePath
     * @return
     */
    public static boolean verifyCertificate(String certificatePath) {
        return verifyCertificate(new Date(), certificatePath);
    }

    /**
     * 验证数字证书是否过期
     *
     * @param date
     * @param certificatePath
     * @return
     */
    public static boolean verifyCertificate(Date date, String certificatePath) {
        boolean status = true;
        try {
            Certificate certificate = getCertificate(certificatePath);
            status = verifyCertificate(date, certificate);
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;
    }

    /**
     * 验证证书是否过期或者无效
     *
     * @param date
     * @param certificate
     * @return
     */
    private static boolean verifyCertificate(Date date, Certificate certificate) {
        boolean status = true;
        X509Certificate x509Certificate = (X509Certificate) certificate;
        try {
            x509Certificate.checkValidity(date);
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;

    }

    /**
     * 签名
     *
     * @param sign
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     * @throws Exception
     */
    public static String sign(byte[] sign, String keyStorePath,
                              String alias, String password) throws Exception {
        //获取证书
        X509Certificate x509Certificate = (X509Certificate) getCertificate(keyStorePath, alias, password);
        //获取私钥
        KeyStore keyStore = getKeyStore(keyStorePath, password);
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, password.toCharArray());

        //构建签名
        Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
        signature.initSign(privateKey);
        signature.update(sign);
        return encryptBASE64(signature.sign());
    }

    /**
     * 验证签名
     *
     * @param data
     * @param sign
     * @param keyStorePath
     * @return
     * @throws Exception
     */
    public static boolean verify(byte[] data, String sign,
                                 String keyStorePath) throws Exception {
        //获取证书
        X509Certificate x509Certificate = (X509Certificate) getCertificate(keyStorePath);
        //获取公钥
        PublicKey publicKey = x509Certificate.getPublicKey();
        //构建签名组件
        Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
        signature.initVerify(publicKey);
        signature.update(data);
        return signature.verify(decryptBASE64(sign));
    }

    /**
     * 验证数字证书
     *
     * @param date
     * @param keyStorePath
     * @param alias
     * @param password
     * @return
     */
    public static boolean verifyCertificate(Date date, String keyStorePath,
                                            String alias, String password) {
        boolean status = true;
        try {
            Certificate certificate = getCertificate(keyStorePath, alias, password);
            status = verifyCertificate(date, certificate);
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;
    }

    public static boolean verifyCertificate(String keyStorePath, String alias,
                                            String password) {
        return verifyCertificate(new Date(), keyStorePath, alias, password);
    }

    /**
     * 为HTTPSURLConnection配置SSLSocketFactory
     * @param connection
     * @param password
     * @param keyStorePath
     * @param trustKeyStorePath
     */
    public static void configSSLSocketFactory(HttpsURLConnection connection,
                                              String password, String keyStorePath,
                                              String trustKeyStorePath) throws Exception {
        connection.setSSLSocketFactory(getSSLSocketFactory(password,keyStorePath,trustKeyStorePath));
    }

    private static SSLSocketFactory getSSLSocketFactory(String password, String keyStorePath,
                                                        String trustKeyStorePath) throws Exception {
        //初始化密钥库
        KeyManagerFactory factory = KeyManagerFactory.getInstance(X509);
        KeyStore keyStore = getKeyStore(keyStorePath, password);
        factory.init(keyStore, password.toCharArray());

        //初始化信任库
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(X509);
        KeyStore trustKeyStore = getKeyStore(trustKeyStorePath, password);
        trustManagerFactory.init(trustKeyStore);

        //初始化SSL上下文
        SSLContext sslContext = SSLContext.getInstance(SSL);
        sslContext.init(factory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
        return sslContext.getSocketFactory();
    }

    @Test
    public void testCertificate() throws Exception {
        String password = "123456";
        String alias = "ganganmaster.top";
        String certificatePath = "C:/Users/陈淦/Desktop/keyStore/Gangan.cer";
        String keyStorePath = "C:/Users/陈淦/Desktop/keyStore/Gangan.keystore";
        String input = "真想不到当初我们也讨厌吃苦瓜" +
                "当睇清世间所有定理又何用再怕";

        //公钥加密，私钥解密
        System.out.println("公钥加密，私钥解密");
        byte[] encrypt1 = CertificateCoder.encryptByPublicKey(input.getBytes(), certificatePath);
        byte[] decrypt1 = CertificateCoder.decryptByPrivateKey(encrypt1,keyStorePath,alias,password);
        System.out.println("加密前数据为：" + input + "\n 解密还原后的数据为：" + new String(decrypt1));
        System.out.println("证书的有效性为：" + CertificateCoder.verifyCertificate(certificatePath));

        //私钥加密，公钥解密
        System.out.println("私钥加密，公钥解密");
        byte[] encrypt2 = CertificateCoder.encryptByPrivateKey(input.getBytes(), keyStorePath, alias, password);
        byte[] decrypt2 = CertificateCoder.decryptByPublicKey(encrypt2, certificatePath);
        System.out.println("加密前数据为：" + input + "\n 解密还原后的数据为：" + new String(decrypt2));

        //签名
        //产生签名
        String sign = CertificateCoder.sign(input.getBytes(), keyStorePath, alias, password);
        //验证签名
        boolean verify = CertificateCoder.verify(input.getBytes(),sign,certificatePath);
        System.out.println("签名验证的结果为：" + verify);
    }

}
