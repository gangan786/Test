package com.meizhuo.os.Banker;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.os.Banker
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/27 13:57
 * @UpdateUser:
 * @UpdateDate: 2018/10/27 13:57
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */

public class Resource {

    public String resourceName;

    public int max;

    public int alloc;

    public int need;

    public int request;

    /**
     * 当此字段有值时，其他字段无效
     */
    private int avail;

    public Resource() {
    }

    public Resource(String resourceName, int request) {
        this.resourceName = resourceName;
        this.request = request;
    }

    public Resource(String resourceName, int max, int alloc) {
        this.resourceName = resourceName;
        this.max = max;
        this.alloc = alloc;
        this.need = max - alloc;
    }

    public void setAvail(int avail) {
        this.avail = avail;
    }

    public int getAvail() {
        return avail;
    }

    public void addAlloc(int alloc) {
        this.alloc = this.alloc + alloc;
        this.need = this.need - alloc;
    }
}
