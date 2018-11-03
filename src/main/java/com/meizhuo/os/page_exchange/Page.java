package com.meizhuo.os.page_exchange;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.os.page_exchange
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/11/3 14:14
 * @UpdateUser:
 * @UpdateDate: 2018/11/3 14:14
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Page {

    private String name;

    private String id;

    private int count=0;

    public Page(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void addCount(){
        count++;
    }

    public void reSetCount(){
        count=0;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
