package com.meizhuo.DesignPatterns.ConcurrencyDP_1_不可变对象;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_1_不可变对象
 * @ClassName: ${TYPE_NAME}
 * @Description: 彩信中心信息
 * @Author: Gangan
 * @CreateDate: 2019/3/20 21:50
 * @UpdateUser:
 * @UpdateDate: 2019/3/20 21:50
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class MMSCInfo {

    private final String deviceID;

    private final String url;

    private final int maxAttachmentSizeInBytes;

    public MMSCInfo(String deviceID, String url, int maxAttachmentSizeInBytes) {
        this.deviceID = deviceID;
        this.url = url;
        this.maxAttachmentSizeInBytes = maxAttachmentSizeInBytes;
    }

    public MMSCInfo(MMSCInfo mmscInfo) {

        deviceID = mmscInfo.deviceID;
        url = mmscInfo.url;
        maxAttachmentSizeInBytes = mmscInfo.maxAttachmentSizeInBytes;

    }

    public String getDeviceID() {
        return deviceID;
    }

    public String getUrl() {
        return url;
    }

    public int getMaxAttachmentSizeInBytes() {
        return maxAttachmentSizeInBytes;
    }

    @Override
    public String toString() {
        return "MMSCInfo{" +
                "deviceID='" + deviceID + '\'' +
                ", url='" + url + '\'' +
                ", maxAttachmentSizeInBytes=" + maxAttachmentSizeInBytes +
                '}';
    }
}
