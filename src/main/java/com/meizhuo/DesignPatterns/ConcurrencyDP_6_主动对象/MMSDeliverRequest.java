package com.meizhuo.DesignPatterns.ConcurrencyDP_6_主动对象;

import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_6_主动对象
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/4/2 11:23
 * @UpdateUser:
 * @UpdateDate: 2019/4/2 11:23
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class MMSDeliverRequest implements Serializable {

    private String transactionID;
    private String messageType = "Delivery.req";
    private String senderAddress;

    // 彩信消息接收方
    private Recipient recipient = new Recipient();
    private String subject;
    private Attachment attachment = new Attachment();

    private long expiry;
    private Date timeStamp;

    public long getExpiry() {
        return expiry;
    }

    public MMSDeliverRequest() {

    }

    public void setExpiry(long expiry) {
        this.expiry = expiry;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "MM7DeliverRequest [transactionID=" + transactionID
                + ", messageType=" + messageType + ", senderAddress="
                + senderAddress + ", recipient=" + recipient + ", subject="
                + subject + ", attachment=" + attachment + "]";
    }

    private static final long serialVersionUID = 302185079311891797L;

}
