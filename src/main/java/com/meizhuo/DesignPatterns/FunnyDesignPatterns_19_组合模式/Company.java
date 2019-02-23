package com.meizhuo.DesignPatterns.FunnyDesignPatterns_19_组合模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_19_组合模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/23 11:16
 * @UpdateUser:
 * @UpdateDate: 2019/2/23 11:16
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public abstract class Company {

    protected String name;

    public Company(String name) {
        this.name = name;
    }

    /**
     * 添加所属子节点
     * @param company
     */
    public abstract void add(Company company);

    /**
     * 移除所属子节点
     * @param company
     */
    public abstract void remove(Company company);

    /**
     * 显示子节点
     * @param depth
     */
    public abstract void display(int depth);

    /**
     * 各节点的具体实现（职责）
     */
    public abstract void lineOfDuty();
}
