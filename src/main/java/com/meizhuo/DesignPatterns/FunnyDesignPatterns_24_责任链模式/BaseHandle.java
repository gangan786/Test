package com.meizhuo.DesignPatterns.FunnyDesignPatterns_24_责任链模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_24_责任链模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/28 11:05
 * @UpdateUser:
 * @UpdateDate: 2019/2/28 11:05
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public abstract class BaseHandle {

    protected BaseHandle nextHandle;


    public void setNextHandle(BaseHandle nextHandle) {
        this.nextHandle = nextHandle;
    }

    /**
     * 处理请求，无法处理就转移至下一个处理
     * @param requestLevel
     */
    public abstract void handleRequest(int requestLevel);

}
