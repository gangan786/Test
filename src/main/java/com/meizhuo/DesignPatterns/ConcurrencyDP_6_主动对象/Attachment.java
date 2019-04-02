package com.meizhuo.DesignPatterns.ConcurrencyDP_6_主动对象;

import java.io.Serializable;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_6_主动对象
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/4/2 11:31
 * @UpdateUser:
 * @UpdateDate: 2019/4/2 11:31
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Attachment implements Serializable {
    private static final long serialVersionUID = 8862516481154597936L;

    private String contentType;
    private byte[] content = new byte[0];

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Attachment [contentType=" + contentType + ", content="
                + content.length + "]";
    }

}
