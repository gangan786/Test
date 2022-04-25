package com.meizhuo.encryption;




import org.junit.Test;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;

/**
 * @Classname PBECoder
 * @Description PBE安全编码组件
 * @Date 2019/6/2 20:40
 * @Created by Gangan
 */
public class PBECoder extends Coder {

    public static final String ALGORITHM = "PBEWITHMD5andDES";

    /**
     * 产生盐值
     *
     * @return
     */
    public static byte[] initSalt() {
        byte[] salts = new byte[8];
        new Random().nextBytes(salts);
        return salts;
    }

    /**
     * 秘钥转换，将口令密码转化为足够长度的秘钥
     *
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private static Key toKey(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey key = keyFactory.generateSecret(keySpec);
        return key;
    }

    /**
     * 加密
     *
     * @param data
     * @param password
     * @param salts
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, String password, byte[] salts)
            throws Exception {
        Key key = toKey(password);
        PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salts, 100);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key, pbeParameterSpec);
        return cipher.doFinal(data);
    }

    /**
     * 解密
     *
     * @param data
     * @param password
     * @param salts
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, String password, byte[] salts)
            throws Exception {
        Key key = toKey(password);
        PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salts, 100);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key, pbeParameterSpec);
        return cipher.doFinal(data);

    }

    @Test
    public void testPBE() throws Exception {
        String data = "电影将延续上一部的故事，" +
                "动物基因组学（帝王计划）研究机构将会有更繁重的研究任务，" +
                "因为一大堆大小不一的怪物要登场，" +
                "而哥斯拉也要与魔斯拉、拉顿以及它的强敌基多拉相遇。" +
                "这些古老的超级怪兽将一一登场，" +
                "此前他们一直被认为只存在于神话当中，" +
                "这一次他们将为争夺“怪兽之王”而战，" +
                "人类的生存也受到严重威胁。" +
                "随着《哥斯拉》和《金刚：骷髅岛》在全球范围内取得成功，" +
                "传奇影业和华纳兄弟影业联手开启了怪兽宇宙系列电影的新篇章—一部史诗级动作冒险巨制。" +
                "在这部电影中，哥斯拉将和众多大家在流行文化中所熟知的怪兽展开较量。" +
                "全新故事中，研究神秘动物学的机构“帝王组织”成员将勇敢直面巨型怪兽，" +
                "其中强大的哥斯拉也将和魔斯拉、拉顿和它的死对头——三头王基多拉展开激烈对抗。" +
                "当这些只存在于传说里的超级生物再度崛起时，它们将展开王者争霸，人类的命运岌岌可危……";
        byte[] salt = PBECoder.initSalt();
        String password="Gangan miss Dong";
        byte[] encrypt = PBECoder.encrypt(data.getBytes("utf-8"), password, salt);
        byte[] decrypt = PBECoder.decrypt(encrypt, password, salt);
        System.out.println("解密后的数据为："+new String(decrypt));
    }
}
