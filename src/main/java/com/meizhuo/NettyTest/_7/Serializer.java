package com.meizhuo.NettyTest._7;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.NettyTest._7
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/9/29 13:25
 * @UpdateUser:
 * @UpdateDate: 2018/9/29 13:25
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public interface Serializer {

    /**
     * json序列化
     */
    byte JSON_SERIALIZER=1;

    /**
     * 默认序列化算法
     */
    Serializer DEFAULT = new JSONSerializer();

    /**
     * 获取序列化算法
     *
     * @return
     */
    byte getSerializerAlgorithm();

    /**
     * java对象转化成二进制
     *
     * @param object
     * @return
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换成java对象
     * @param clazz
     * @param bytes
     * @param <T>
     * @return
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);

}
